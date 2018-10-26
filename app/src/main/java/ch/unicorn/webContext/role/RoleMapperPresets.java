
package ch.unicorn.webContext.role;

import static ch.unicorn.config.mapping.util.PresetCreator.mapping;

import ch.unicorn.config.mapping.MapperPreset;
import ch.unicorn.config.mapping.MapperPresetProvider;
import ch.unicorn.config.mapping.MapperPresetsListing;
import ch.unicorn.config.mapping.MappingProvider;
import ch.unicorn.config.mapping.util.Mapping;
import ch.unicorn.webContext.role.dto.RoleDTO;
import ch.unicorn.webContext.role.dto.RoleDTOUD;


@MapperPresetsListing
public enum RoleMapperPresets implements MapperPresetProvider, MappingProvider {
	ROLE_TO_ROLE_DTO(mapping(Role.class, RoleDTO.class)), ROLE_TO_ROLE_DTOUD(mapping(Role.class, RoleDTOUD.class)),
	ROLE_DTO_TO_ROLE(mapping(RoleDTO.class, Role.class)), ROLE_DTOUD_TO_ROLE(mapping(RoleDTOUD.class, Role.class));

	private Mapping mapping;

	/**
	 * @param mapping
	 */
	private RoleMapperPresets(Mapping mapping) {
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
