package ch.unicorn.webContext.comment.dto;

import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.webContext.post.Post;
import ch.unicorn.webContext.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class defines a primitive version of the entity comment.
 *
 *
 */
@Mappable
@ApiModel(value = "CommentDTO", description = "This class defines a primitive version of the entity comment")
public class CommentDTO {

	@ApiModelProperty(required = true)
	private Long id;

	@ApiModelProperty(required = true)
	private String comment;

	@ApiModelProperty(required = true)
	private Post post;

	@ApiModelProperty(required = true)
	private User user;

	/**
	 *
	 */
	public CommentDTO() {
	}

	/**
	 * @param id
	 * @param comment
	 * @param post
	 * @param user
	 */
	public CommentDTO(Long id, String comment, Post post, User user) {
		super();
		this.id = id;
		this.comment = comment;
		this.post = post;
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