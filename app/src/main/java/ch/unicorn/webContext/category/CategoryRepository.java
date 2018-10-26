package ch.unicorn.webContext.category;

import org.springframework.stereotype.Repository;

import ch.unicorn.config.generic.ExtendedJpaRepository;

@Repository
interface CategoryRepository extends ExtendedJpaRepository<Category>{
}
