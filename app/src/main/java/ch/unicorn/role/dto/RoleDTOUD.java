package ch.unicorn.role.dto;

import java.util.Set;

import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.authority.dto.AuthorityDTOUD;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the DTOUD of the Role entity
 */
@Mappable
@ApiModel(value = "RoleDTO", description = "This class is the DTOUD of the Role entity")
public class RoleDTOUD {

	@ApiModelProperty(required = true)
	private String name;

	@ApiModelProperty(required = true)
	private Set<AuthorityDTOUD> authorities;

	/**
	 *
	 */
	public RoleDTOUD() {
	}

	/**
	 * @param name
	 * @param authorities
	 */
	public RoleDTOUD(String name, Set<AuthorityDTOUD> authorities) {
		super();
		this.name = name;
		this.authorities = authorities;
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

	/**
	 * @return the authorities
	 */
	public Set<AuthorityDTOUD> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<AuthorityDTOUD> authorities) {
		this.authorities = authorities;
	}

}
