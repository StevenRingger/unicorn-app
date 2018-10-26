package ch.unicorn.webContext.rating;

import static ch.unicorn.config.mapping.util.PresetCreator.mapping;

import ch.unicorn.config.mapping.MapperPreset;
import ch.unicorn.config.mapping.MapperPresetProvider;
import ch.unicorn.config.mapping.MapperPresetsListing;
import ch.unicorn.config.mapping.MappingProvider;
import ch.unicorn.config.mapping.util.Mapping;
import ch.unicorn.webContext.rating.dto.RatingDTO;


@MapperPresetsListing
public enum RatingMapperPresets implements MapperPresetProvider, MappingProvider {
	RATING_TO_RATING_DTO(mapping(Rating.class, RatingDTO.class)),
	RATING_DTO_TO_RATING(mapping(RatingDTO.class, Rating.class));

	private Mapping mapping;

	/**
	 * @param mapping
	 */
	private RatingMapperPresets(Mapping mapping) {
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
