package ch.unicorn.webContext.role.dto;

import java.util.Set;

import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.webContext.authority.dto.AuthorityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the DTO of the Role entity
 * 
 */
@Mappable
@ApiModel(value = "RoleDTO", description = "This class is the DTO of the Role entity")
public class RoleDTO {

	@ApiModelProperty
	private Long id;

	@ApiModelProperty(required = true)
	private String name;

	@ApiModelProperty(required = true)
	private Set<AuthorityDTO> authorities;

	/**
	 *
	 */
	public RoleDTO() {
	}

	/**
	 * @param id
	 * @param name
	 * @param authorities
	 */
	public RoleDTO(Long id, String name, Set<AuthorityDTO> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.authorities = authorities;
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

	/**
	 * @return the authorities
	 */
	public Set<AuthorityDTO> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<AuthorityDTO> authorities) {
		this.authorities = authorities;
	}
}
