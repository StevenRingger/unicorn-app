package ch.unicorn.webContext.post;

import org.springframework.stereotype.Repository;

import ch.unicorn.config.generic.ExtendedJpaRepository;

@Repository
interface PostRepository extends ExtendedJpaRepository<Post>{
}
