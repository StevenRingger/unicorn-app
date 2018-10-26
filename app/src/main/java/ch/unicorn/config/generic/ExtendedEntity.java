package ch.unicorn.config.generic;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import ch.unicorn.webContext.authority.Authority;
import ch.unicorn.webContext.role.Role;
import ch.unicorn.webContext.user.User;
import io.swagger.annotations.ApiModel;

/**
 * This class that covers the common attributes of all entities
 *
 */
@MappedSuperclass
@ApiModel(value = "ExtendedEntity", discriminator = "SuperClass", subTypes = { Authority.class, Role.class,
		User.class })
public abstract class ExtendedEntity {
	
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * 
	 */
	public ExtendedEntity() {
		super();
	}

	/**
	 * @param id
	 */
	public ExtendedEntity(Long id) {
		super();
		this.id = id;
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
}