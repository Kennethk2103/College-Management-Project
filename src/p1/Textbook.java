package p1;

import java.io.Serializable;

public class Textbook implements Serializable{
	private String Title;
	private Name name;
	private String isbn;
	private double price;
	public Textbook(String title, Name name, String isbn, double price) {
		super();
		Title = title;
		this.name = name;
		this.isbn = isbn;
		this.price = price;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Textbook [Title=" + Title + ", name=" + name + ", isbn=" + isbn + ", price=" + price + "]";
	}
	

}
