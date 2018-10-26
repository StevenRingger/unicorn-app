package ch.unicorn.webContext.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.unicorn.config.generic.ExtendedServiceImpl;

@Component
public class CategoryServiceImpl extends ExtendedServiceImpl<Category> implements CategoryService{

	/**
	 * @param repository
	 */
	@Autowired
	CategoryServiceImpl(CategoryRepository repository) {
		super(repository);
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}
}
