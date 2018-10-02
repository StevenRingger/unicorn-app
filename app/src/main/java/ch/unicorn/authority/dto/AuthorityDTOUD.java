package ch.unicorn.authority.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the entity authority. A role can hold multiple authorities e.g
 * "WRITE_PRIVILEDGE" or "READ_PRIVILEDGE".
 *
 */

@ApiModel(value = "AuthorityDTOUD", description = "A Role can hold multiple Authorities, e.g WRITE_PRIVILEDGE or READ_PRIVILEDGE")
public class AuthorityDTOUD {

	@ApiModelProperty(required = true)
	private String name;

	/**
	 *
	 */
	public AuthorityDTOUD() {
	}

	/**
	 * @param name
	 */
	public AuthorityDTOUD(String authority) {
		name = authority;
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
