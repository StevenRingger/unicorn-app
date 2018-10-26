package ch.unicorn.webContext.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.unicorn.config.generic.ExtendedServiceImpl;

@Component
public class PostServiceImpl extends ExtendedServiceImpl<Post> implements PostService{

	/**
	 * @param repository
	 */
	@Autowired
	PostServiceImpl(PostRepository repository) {
		super(repository);
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}
}
