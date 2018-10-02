package ch.unicorn.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ch.unicorn.generic.ExtendedEntity;


/**
 * This class is the entity authority. A role can hold multiple authorities e.g
 * "WRITE_PRIVILEDGE" or "READ_PRIVILEDGE".
 */
@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {

	@Column(name = "name")
	private String name;
	
	/**
	 * 
	 */
	public Authority(){
		
	}

	/**
	 * 
	 */
	public Authority(Long id) {
		super(id);
	}

	/**
	 * @param id
	 * @param authority
	 */
	public Authority(Long id, String name) {
		super(id);
		this.name = name;
	}

	/**
	 * @return the authority
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
