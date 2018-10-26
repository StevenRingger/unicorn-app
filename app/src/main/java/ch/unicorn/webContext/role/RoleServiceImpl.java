package ch.unicorn.webContext.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.unicorn.config.generic.ExtendedServiceImpl;

@Component
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService{

	/**
	 * @param repository
	 */
	@Autowired
	RoleServiceImpl(RoleRepository repository) {
		super(repository);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role findByName(String name) {
		Role role = ((RoleRepository) repository).findByName(name);
		return role;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByName(String name) {
		((RoleRepository) repository).deleteByName(name);
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}


}