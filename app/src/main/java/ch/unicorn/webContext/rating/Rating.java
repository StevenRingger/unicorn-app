package ch.unicorn.webContext.rating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.unicorn.config.generic.ExtendedEntity;
import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.webContext.post.Post;
import ch.unicorn.webContext.user.User;

/**
 * This class is the Entity Rating.
 *
 */
@Mappable
@Entity
@Table(name = "rating")
public class Rating extends ExtendedEntity {

	@Column(name = "rating")
	private Integer rating;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	/**
	 *  Empty constructor
	 */
	public Rating() {
		
	}

	/**
	 * 
	 * @param id
	 */
	public Rating(Long id) {
		super(id);
	}

	/**
	 * @param rating
	 * @param user
	 * @param post
	 */
	public Rating(Integer rating, User user, Post post) {
		super();
		this.rating = rating;
		this.user = user;
		this.post = post;
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
	
	/**
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}
}