package com.microsservicos.bookservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "book")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 180)
	private String author;
	
	@Column(name = "launch_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date launchDate;
	
	@Column(nullable = false)
	private Double price;
		
	@Column(nullable = false, length = 250)
	private String title;
	
	 /*
     * A annotation "@Transient" é para definir que um atributo não será persistido no
     * banco. Essa não é uma boa prática, está sendo feito assim porque no curso
     * o professor passou só para atender a necessidade básica, de ensinar microsserviços.
     * A forma correta seria criar uma classe DTO alusiva a esta entidade, para que as boas 
     * práticas sejam seguidas, para implementações de API Rest. 
     * */
	@Transient
	private String currency;
	
	@Transient
	private String environment;
	
	public Book() {
	
	}

	public Book(Long id, String author, String title, 
			Date launchDate, Double price, 
			String currency,
			String environment) {		
		this.id = id;
		this.author = author;
		this.launchDate = launchDate;
		this.price = price;
		this.title = title;
		this.currency = currency;
		this.environment = environment;
	}
	
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", launchDate=" + launchDate + ", price=" + price + ", title="
				+ title + ", currency=" + currency + ", environment=" + environment + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
