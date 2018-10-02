package ch.unicorn.config.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.unicorn.config.PropertyReader;
import ch.unicorn.user.User;
import ch.unicorn.user.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Initial filter that handles the user authentication and JWT generating process
 *
 */
class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private PropertyReader propertyReader;

	/**
	 * @param requiresAuthenticationRequestMatcher
	 * @param authenticationManager
	 * @param propertyReader
	 */
	JWTAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher,
			AuthenticationManager authenticationManager, PropertyReader propertyReader) {
		super(requiresAuthenticationRequestMatcher);
		setAuthenticationManager(authenticationManager);
		this.propertyReader = propertyReader;
	}

	/**
	 * Attempts to login a user with the given credentials
	 *
	 * @param req Client request
	 * @param res Response to client request
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		try {
			User creds = new ObjectMapper().readValue(req.getInputStream(), User.class);
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets invoked in case the method attemptAuthentication successfully
	 * authenticated the given user
	 *
	 * @param req   Client request
	 * @param res   Response to client request
	 * @param chain Chain/Order of filters
	 * @param auth  Authentication context that got generated in
	 *              attemptAuthentication
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		// Adds the UserDetailsImpl logic to the authenticated user
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) auth.getPrincipal();
		User user = userDetailsImpl.getUser();
		String subject = Long.toString(user.getId());

		// Builds the JWT
		String token = Jwts.builder().setSubject(subject)
				.setExpiration(new Date(System.currentTimeMillis() + propertyReader.getIntProperty("jwt.expiration-time")))
				.signWith(SignatureAlgorithm.HS512, propertyReader.getStringProperty("jwt.secret").getBytes())
				.compact();
		res.addHeader(propertyReader.getStringProperty("jwt.header-string"),propertyReader.getStringProperty("jwt.token-prefix") + token);
	}
	
}
