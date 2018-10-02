package ch.unicorn.config.mapping;

import ch.unicorn.config.mapping.util.Mapping;

/**
 * This interface ensures that a Mapping can be provided by the implementing
 * class. All MapperPreset-Enums must implement this interface
 */
public interface MappingProvider {
	/**
	 * This method returns the {@link Mapping} provided by this
	 * {@link MappingProvider}
	 *
	 * @return Mapping The {@link Mapping} provided by this {@link MappingProvider}
	 */
	Mapping getMapping();
}
