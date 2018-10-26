package ch.unicorn.webContext.comment;

import static ch.unicorn.config.mapping.util.PresetCreator.mapping;

import ch.unicorn.config.mapping.MapperPreset;
import ch.unicorn.config.mapping.MapperPresetProvider;
import ch.unicorn.config.mapping.MapperPresetsListing;
import ch.unicorn.config.mapping.MappingProvider;
import ch.unicorn.config.mapping.util.Mapping;
import ch.unicorn.webContext.comment.dto.CommentDTO;


@MapperPresetsListing
public enum CommentMapperPresets implements MapperPresetProvider, MappingProvider {
	COMMENT_TO_COMMENT_DTO(mapping(Comment.class, CommentDTO.class)),
	COMMENT_DTO_TO_COMMENT(mapping(CommentDTO.class, Comment.class));

	private Mapping mapping;

	/**
	 * @param mapping
	 */
	private CommentMapperPresets(Mapping mapping) {
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
