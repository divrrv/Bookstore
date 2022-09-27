package hh.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long categoryid;
	private String name;
	
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;	
	}
	
	public Long getCategoryid() {
		return categoryid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Category {categoryid=" + categoryid + ", name" + name + "}";
	}

}
