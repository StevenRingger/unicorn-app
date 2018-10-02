package ch.unicorn.role;

import ch.unicorn.generic.ExtendedJpaRepository;

public interface RoleRepository extends ExtendedJpaRepository<Role>{
	/**
	 * This method finds an role with a given name
	 *
	 * @param name Descriptive name of role
	 * @return Returns requested role with given descriptive name of role
	 */
	Role findByName(String name);

	/**
	 * This method deletes the requested role with a given name
	 *
	 * @param name Descriptive name of role
	 */
	void deleteByName(String name);
}
