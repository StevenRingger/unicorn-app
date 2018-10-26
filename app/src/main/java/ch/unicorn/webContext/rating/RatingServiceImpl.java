package ch.unicorn.webContext.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.unicorn.config.generic.ExtendedServiceImpl;

@Component
public class RatingServiceImpl extends ExtendedServiceImpl<Rating> implements RatingService{

	/**
	 * @param repository
	 */
	@Autowired
	RatingServiceImpl(RatingRepository repository) {
		super(repository);
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}
}
