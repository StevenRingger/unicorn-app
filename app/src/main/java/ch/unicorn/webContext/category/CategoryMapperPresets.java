package ch.unicorn.webContext.category;

import static ch.unicorn.config.mapping.util.PresetCreator.mapping;

import ch.unicorn.config.mapping.MapperPreset;
import ch.unicorn.config.mapping.MapperPresetProvider;
import ch.unicorn.config.mapping.MapperPresetsListing;
import ch.unicorn.config.mapping.MappingProvider;
import ch.unicorn.config.mapping.util.Mapping;
import ch.unicorn.webContext.category.dto.CategoryDTO;


@MapperPresetsListing
public enum CategoryMapperPresets implements MapperPresetProvider, MappingProvider {
	CATEGORY_TO_CATEGORY_DTO(mapping(Category.class, CategoryDTO.class)),
	CATEGORY_DTO_TO_CATEGORY(mapping(CategoryDTO.class, Category.class));

	private Mapping mapping;

	/**
	 * @param mapping
	 */
	private CategoryMapperPresets(Mapping mapping) {
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
