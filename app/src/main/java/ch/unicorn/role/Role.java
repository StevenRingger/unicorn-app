package ch.unicorn.role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import ch.unicorn.authority.Authority;
import ch.unicorn.generic.ExtendedEntity;

@Entity
@Table(name = "roles")
public class Role extends ExtendedEntity{
	
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "name")
	String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_authority", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private Set<Authority> authorities = new HashSet<>();

	/**
	 * 
	 */
	public Role() {
	}

	/**
	 * @param id
	 * @param role
	 * @param authorities
	 */
	public Role(Long id, String name, Set<Authority> authorities) {
		this.id = id;
		this.name = name;
		this.authorities = authorities;
	}

	/**
	 * @return the role
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param role the role to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the authorities
	 */
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
}
