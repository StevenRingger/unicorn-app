package ch.unicorn.webContext.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.unicorn.config.generic.ExtendedServiceImpl;

/**
 * This class implements all data access related methods targeted towards the
 * entity authority.
 *
 */
@Service
class AuthorityServiceImpl extends ExtendedServiceImpl<Authority> implements AuthorityService {

	/**
	 * @param repository
	 */
	@Autowired
	AuthorityServiceImpl(AuthorityRepository repository) {
		super(repository);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Authority findByName(String name) {
		Authority authority = ((AuthorityRepository) repository).findByName(name);
		return authority;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByName(String name) {
		((AuthorityRepository) repository).deleteByName(name);
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}
}