package ch.unicorn.webContext.comment;

import org.springframework.stereotype.Repository;

import ch.unicorn.config.generic.ExtendedJpaRepository;

@Repository
interface CommentRepository extends ExtendedJpaRepository<Comment>{
}
