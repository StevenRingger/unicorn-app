package ch.unicorn.webContext.post.dto;


import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.webContext.category.Category;
import ch.unicorn.webContext.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class defines a primitive version of the entity post.
 */

@Mappable
@ApiModel(value = "PostDTO", description = "This class defines a primitive version of the entity post")
public class PostDTO {

	@ApiModelProperty(required = true)
	private Long id;
	
	@ApiModelProperty(required = true)
	private String postName;
	
	@ApiModelProperty(required = true)
	private String imagePath;
	
	@ApiModelProperty(required = true)
	private Category category;
	
	@ApiModelProperty(required = true)
	private User user;

	/**
	 *
	 */
	public PostDTO() {
	}

	/**
	 * @param id
	 * @param postName
	 * @param imagePath
	 * @param ratings
	 * @param comments
	 * @param category
	 * @param user
	 */
	public PostDTO(Long id, String postName, String imagePath, 
			Category category, User user) {
		super();
		this.id = id;
		this.postName = postName;
		this.imagePath = imagePath;
		this.category = category;
		this.user = user;
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
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}