package ch.unicorn.config.generic;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This generic interface that extends JPARepository and implements all methods which
 * are common among the domain repositories
 *
 */
public interface ExtendedJpaRepository<T extends ExtendedEntity> extends JpaRepository<T, Long> {

}
