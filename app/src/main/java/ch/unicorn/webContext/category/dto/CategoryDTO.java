package ch.unicorn.webContext.category.dto;

import java.util.Set;

import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.webContext.post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class defines a primitive version of the entity category.
 */

@Mappable
@ApiModel(value = "CategoryDTO", description = "This class defines a primitive version of the entity category")
public class CategoryDTO {

	@ApiModelProperty(required = true)
	private Long id;

	@ApiModelProperty(required = true)
	private String categoryName;
	
	/**
	 *
	 */
	public CategoryDTO() {
	}

	/**
	 * @param id
	 * @param categoryName
	 * @param posts
	 */
	public CategoryDTO(Long id, String categoryName, Set<Post> posts) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryname the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}