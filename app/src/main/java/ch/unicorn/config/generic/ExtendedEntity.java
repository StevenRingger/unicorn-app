package ch.unicorn.config.generic;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import ch.unicorn.authority.Authority;
import ch.unicorn.role.Role;
import ch.unicorn.user.User;
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
	private long id;

	/**
	 * 
	 */
	public ExtendedEntity() {
		super();
	}

	/**
	 * @param id
	 */
	public ExtendedEntity(long id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
}