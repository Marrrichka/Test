package ua.entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="adition")
public class BookAdition extends AbstractEntity{
	
	@Column(name="adition")
	private String adition;
	

	@OneToMany(mappedBy="bookadition")
	private List<Book> books = new ArrayList<>();


	public BookAdition() {
		super();
	}


	public String getAdition() {
		return adition;
	}


	public void setAdition(String adition) {
		this.adition = adition;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
	


}
