package hh.Bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String author;
	@Column(name= "Publishing_year")
	private int year;
	private String isbn;
	private double price;
	
	@ManyToOne
	@JoinColumn(name= "categoryid")
	private Category category;
	
	public Book() {}
	
	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
		
	}
	
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", title=" + title + ", author=" + author +",year=" + year + ", isbn=" + isbn + ", price" + price + " category =" + this.getCategory() + "]";
		else
			return  "Book [id=" + id + ", title=" + title + ", author=" + author +",year=" + year + ", isbn=" + isbn + ", price" + price + "]"; 
	}
	
	

}
