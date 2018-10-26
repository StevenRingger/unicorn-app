package ch.unicorn.webContext.authority.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the entity authority. A role can hold multiple authorities e.g
 * "WRITE_PRIVILEDGE" or "READ_PRIVILEDGE".
 *
 */

@ApiModel(value = "AuthorityDTO", description = "A Role can hold multiple Authorities, e.g WRITE_PRIVILEDGE or READ_PRIVILEDGE")
public class AuthorityDTO {

	@ApiModelProperty(required = true)
	private Long id;

	@ApiModelProperty(required = true)
	private String name;

	/**
	 *
	 */
	public AuthorityDTO() {
	}

	/**
	 * @param id
	 * @param name
	 */
	public AuthorityDTO(Long id, String authority) {
		this.id = id;
		name = authority;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
