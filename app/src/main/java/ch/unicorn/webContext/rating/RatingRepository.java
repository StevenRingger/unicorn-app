package ch.unicorn.webContext.rating;

import org.springframework.stereotype.Repository;

import ch.unicorn.config.generic.ExtendedJpaRepository;



@Repository
interface RatingRepository extends ExtendedJpaRepository<Rating>{
}
