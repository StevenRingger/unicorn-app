package ch.unicorn.authority;

import static ch.unicorn.config.mapping.util.PresetCreator.mapping;

import ch.unicorn.config.mapping.MapperPreset;
import ch.unicorn.config.mapping.MapperPresetProvider;
import ch.unicorn.config.mapping.MapperPresetsListing;
import ch.unicorn.config.mapping.MappingProvider;
import ch.unicorn.config.mapping.util.Mapping;
import ch.unicorn.authority.dto.AuthorityDTO;
import ch.unicorn.authority.dto.AuthorityDTOUD;

@MapperPresetsListing
public enum AuthorityMapperPresets implements MapperPresetProvider, MappingProvider {
	AUTHORITY_TO_AUTHORITY_DTO(mapping(Authority.class, AuthorityDTO.class)),
	AUTHORITY_TO_AUTHORITY_DTOUD(mapping(Authority.class, AuthorityDTOUD.class)),
	AUTHORITY_DTO_TO_AUTHORITY(mapping(AuthorityDTO.class, Authority.class)),
	AUTHORITY_DTOUD_TO_AUTHORITY(mapping(AuthorityDTOUD.class, Authority.class));

	private Mapping mapping;

	/**
	 * @param mapping
	 */
	private AuthorityMapperPresets(Mapping mapping) {
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
