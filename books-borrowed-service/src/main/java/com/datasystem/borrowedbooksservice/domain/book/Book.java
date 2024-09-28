package com.datasystem.borrowedbooksservice.domain.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Book {

	@Id
	String isbn;
	String title;
	String author;
	String category;
	String borrower;

}