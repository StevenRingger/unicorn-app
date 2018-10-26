package ch.unicorn.webContext.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.unicorn.config.generic.ExtendedEntity;
import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.webContext.category.Category;
import ch.unicorn.webContext.user.User;

/**
 * This class is the Entity Post.
 *
 */
@Mappable
@Entity
@Table(name = "post")
public class Post extends ExtendedEntity {

	@Column(name = "post_name")
	private String postName;

	@Column(name = "image_path")
	private String imagePath;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	/**
	 *  Empty constructor
	 */
	public Post() {
		
	}
	
	/**
	 * 
	 * @param id
	 */
	public Post(Long id) {
		super(id);
	}

	/**
	 * @param postName
	 * @param imagePath
	 * @param ratings
	 * @param comments
	 * @param category
	 * @param user
	 */
	public Post(String postName, String imagePath, Category category,
			User user) {
		super();
		this.postName = postName;
		this.imagePath = imagePath;
		this.category = category;
		this.user = user;
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