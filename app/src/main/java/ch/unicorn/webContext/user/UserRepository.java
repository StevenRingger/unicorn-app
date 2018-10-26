package ch.unicorn.webContext.user;

import org.springframework.stereotype.Repository;

import ch.unicorn.config.generic.ExtendedJpaRepository;



@Repository
interface UserRepository extends ExtendedJpaRepository<User>{

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
