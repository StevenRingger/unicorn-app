package ch.unicorn.config.mapping;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This marker annotation marks a class as a mappable class to be registered
 * with the global mapper at application startup.
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Mappable {

}