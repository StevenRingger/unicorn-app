package ch.unicorn.generic;

import java.util.List;
import java.util.Optional;

/**
 * Generic abstract class that implements the CrudService
 *
 */
public abstract class ExtendedServiceImpl<T extends ExtendedEntity> implements
		ExtendedService<T> {
	
	protected ExtendedJpaRepository<T> repository;

	/**
	 * @param repository
	 */
	public ExtendedServiceImpl(ExtendedJpaRepository<T> repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(T entity) {
		repository.save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T entity) {
		repository.delete(entity);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(T entity) {
		repository.save(entity);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T findById(Long id) {
		Optional<T> entity = repository.findById(id);
		return entity.get();
	}
	
}
