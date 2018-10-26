package ch.unicorn.webContext.rating.dto;

import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.webContext.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class defines a primitive version of the entity rating.
 *
 *
 */
@Mappable
@ApiModel(value = "RatingDTO", description = "This class defines a primitive version of the entity rating")
public class RatingDTO {

	@ApiModelProperty(required = true)
	private Long id;
	
	@ApiModelProperty(required = true)
	private Integer rating;
	
	@ApiModelProperty(required = true)
	private User user;

	/**
	 * 
	 */
	public RatingDTO() {
	}

	/**
	 * @param id
	 * @param rating
	 * @param user
	 */
	public RatingDTO(Long id, Integer rating, User user) {
		super();
		this.id = id;
		this.rating = rating;
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
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
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