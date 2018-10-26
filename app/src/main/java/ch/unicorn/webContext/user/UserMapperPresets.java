package ch.unicorn.webContext.user;

import static ch.unicorn.config.mapping.util.PresetCreator.mapping;

import ch.unicorn.config.mapping.MapperPreset;
import ch.unicorn.config.mapping.MapperPresetProvider;
import ch.unicorn.config.mapping.MapperPresetsListing;
import ch.unicorn.config.mapping.MappingProvider;
import ch.unicorn.config.mapping.util.Mapping;
import ch.unicorn.webContext.user.dto.UserDTO;


@MapperPresetsListing
public enum UserMapperPresets implements MapperPresetProvider, MappingProvider {
	USER_TO_USER_DTO(mapping(User.class, UserDTO.class)),
	USER_DTO_TO_USER(mapping(UserDTO.class, User.class));

	private Mapping mapping;

	/**
	 * @param mapping
	 */
	private UserMapperPresets(Mapping mapping) {
		this.mapping = mapping;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mapping getMapping() {
		return mapping;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapperPreset getPreset() {
		return getMapping().getPreset();
	}

}
