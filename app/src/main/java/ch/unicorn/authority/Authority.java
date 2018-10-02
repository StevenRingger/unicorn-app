package ch.unicorn.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ch.unicorn.config.generic.ExtendedEntity;


/**
 * This class is the entity authority. A role can hold multiple authorities e.g
 * "WRITE_PRIVILEDGE" or "READ_PRIVILEDGE".
 *
 */
@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {

	@Column(name = "name")
	private String name;

	/**
	 *
	 */
	public Authority() {

	}

	/**
	 *
	 */
	public Authority(Long id) {
		super(id);
	}

	/**
	 * @param id
	 * @param name
	 */
	public Authority(Long id, String authority) {
		super(id);
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
