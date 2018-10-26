package ch.unicorn.webContext.user.dto;

import java.sql.Date;
import java.util.Set;

import ch.unicorn.config.mapping.Mappable;
import ch.unicorn.webContext.role.dto.RoleDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class defines a primitive version of the entity user.
 */
@Mappable
@ApiModel(value = "UserDTO", description = "This class defines a primitive version of the entity user")
public class UserDTO {

	@ApiModelProperty(required = true)
	private Long id;

	@ApiModelProperty(required = true)
	private String username;

	@ApiModelProperty(required = true)
	private String password;

	@ApiModelProperty(required = true)
	private String firstname;

	@ApiModelProperty(required = true)
	private String lastname;

	@ApiModelProperty(required = true)
	private String email;

	@ApiModelProperty(required = true)
	private Set<RoleDTO> roles;

	@ApiModelProperty(required = true)
	private Date accountExpirationDate;

	@ApiModelProperty(required = true)
	private Date credentialsExpirationDate;

	@ApiModelProperty(required = true)
	private boolean locked;

	@ApiModelProperty(required = true)
	private boolean enabled;

	/**
	 *
	 */
	public UserDTO() {
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param roles
	 */
	public UserDTO(Long id, String username, String password, String firstname, String lastname, String email, Set<RoleDTO> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roles = roles;
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param roles
	 * @param accountExpirationDate
	 * @param credentialsExpirationDate
	 * @param locked
	 * @param enabled
	 */
	public UserDTO(Long id, String username, String password, String firstname, String lastname, String email,
			Set<RoleDTO> roles, Date accountExpirationDate,
			Date credentialsExpirationDate, boolean locked, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roles = roles;
		this.accountExpirationDate = accountExpirationDate;
		this.credentialsExpirationDate = credentialsExpirationDate;
		this.locked = locked;
		this.enabled = enabled;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the roles
	 */
	public Set<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	/**
	 * @return the accountExpirationDate
	 */
	public Date getAccountExpirationDate() {
		return accountExpirationDate;
	}

	/**
	 * @param accountExpirationDate the accountExpirationDate to set
	 */
	public void setAccountExpirationDate(Date accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	/**
	 * @return the credentialsExpirationDate
	 */
	public Date getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}

	/**
	 * @param credentialsExpirationDate the credentialsExpirationDate to set
	 */
	public void setCredentialsExpirationDate(Date credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}