package ch.unicorn.webContext.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import ch.unicorn.config.generic.ExtendedService;

public interface UserService extends UserDetailsService, ExtendedService<User> {
	
	/**
	 * Finds a User with a given name
	 *
	 * @param name Descriptive name of User
	 * @return Returns requested User with given descriptive name of User
	 */
	User findByUsername(String name);

	/**
	 * Deletes the requested User with a given name
	 *
	 * @param name Descriptive name of User
	 */
	void deleteByUsername(String name);
	
}
