package ch.unicorn.webContext.post;

import static ch.unicorn.config.mapping.util.PresetCreator.mapping;

import ch.unicorn.config.mapping.MapperPreset;
import ch.unicorn.config.mapping.MapperPresetProvider;
import ch.unicorn.config.mapping.MapperPresetsListing;
import ch.unicorn.config.mapping.MappingProvider;
import ch.unicorn.config.mapping.util.Mapping;
import ch.unicorn.webContext.post.dto.PostDTO;


@MapperPresetsListing
public enum PostMapperPresets implements MapperPresetProvider, MappingProvider {
	POST_TO_POST_DTO(mapping(Post.class, PostDTO.class)),
	POST_DTO_TO_POST(mapping(PostDTO.class, Post.class));

	private Mapping mapping;

	/**
	 * @param mapping
	 */
	private PostMapperPresets(Mapping mapping) {
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
