package com.iiht.one2many.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "books")
public class Book implements Serializable  {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String author;
	    @Column(unique = true)
	    private String isbn;

	 
	 //  @OneToMany(cascade = CascadeType.ALL)
	  // @JoinColumn(name =  "bookid_fk", referencedColumnName ="id") //PK ID OF THE BOOK CLASS 1toMany unidirectional
		   // private Set<Page> pages
	   // private Set<Page> pages= new HashSet<>();
	    
	    //bidirectional
	    @OneToMany(mappedBy="book",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	   private Set<Page> pages;

	    public Book() {
	    }

	    public Book(String title, String author, String isbn) {
	        this.title = title;
	        this.author = author;
	        this.isbn = isbn;
	    }
}




////   @OneToMany(mappedBy = "book", fetch = FetchType.LAZY,cascade = CascadeType.ALL)