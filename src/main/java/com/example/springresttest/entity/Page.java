package com.example.springresttest.entity;

import javax.persistence.*;

@Entity
@Table(name = "pages")
public class Page {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pages_sequence")
	@SequenceGenerator(name = "pages_sequence", sequenceName = "pages_sequence", allocationSize = 1)
	@Column(name = "id_of_page")
	private Long idOfPage;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_book")
	private Book book;
	
	public Page() {
		
	}

	public Page(Long idOfPage, String name, Book book) {
		super();
		this.idOfPage = idOfPage;
		this.name = name;
		this.book = book;
	}

	public Long getIdOfPage() {
		return idOfPage;
	}

	public void setIdOfPage(Long idOfPage) {
		this.idOfPage = idOfPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Page [idOfPage=" + idOfPage + ", name=" + name + ", book=" + book + "]";
	}
}
