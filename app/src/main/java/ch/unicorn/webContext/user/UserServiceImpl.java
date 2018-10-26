package ch.unicorn.webContext.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.unicorn.config.generic.ExtendedServiceImpl;

@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * @param repository
	 */
	@Autowired
	UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super(repository);
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User could not be found");
		}
		return new UserDetailsImpl(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findByUsername(String name) {
		User user = ((UserRepository) repository).findByUsername(name);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByUsername(String name) {
		((UserRepository) repository).deleteByUsername(name);
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}

}
