package ch.unicorn.webContext.category;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ch.unicorn.config.generic.ExtendedEntity;
import ch.unicorn.config.mapping.Mappable;

/**
 * This class is the Entity Category.
 *
 */
@Mappable
@Entity
@Table(name = "category")
public class Category extends ExtendedEntity {

	@Column(name = "category_name")
	private String categoryName;

	/**
	 *  Empty constructor
	 */
	public Category() {
		
	}
	
	/**
	 * 
	 * @param id
	 */
	public Category(Long id) {
		super(id);
	}

	/**
	 * @param categoryName
	 * @param posts
	 */
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}