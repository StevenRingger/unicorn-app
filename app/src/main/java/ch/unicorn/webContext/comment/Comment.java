package ch.unicorn.webContext.comment;

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
 * This class is the Entity Comment.
 *
 */
@Mappable
@Entity
@Table(name = "comment")
public class Comment extends ExtendedEntity {

	@Column(name = "comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	/**
	 *  Empty constructor
	 */
	public Comment() {
		
	}
	
	/**
	 * 
	 * @param id
	 */
	public Comment(Long id) {
		super(id);
	}
	
	/**
	 * 
	 * @param comment
	 * @param post
	 * @param user
	 */
	public Comment(String comment, Post post, User user) {
		super();
		this.comment = comment;
		this.post = post;
		this.user = user;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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