package ch.unicorn.webContext.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.unicorn.config.generic.ExtendedServiceImpl;

@Component
public class CommentServiceImpl extends ExtendedServiceImpl<Comment> implements CommentService{

	/**
	 * @param repository
	 */
	@Autowired
	CommentServiceImpl(CommentRepository repository) {
		super(repository);
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}
}
