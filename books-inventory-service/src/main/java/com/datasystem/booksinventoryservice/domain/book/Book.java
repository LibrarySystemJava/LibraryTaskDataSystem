package com.datasystem.booksinventoryservice.domain.book;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Document(collection = "book")
@AllArgsConstructor
public class Book {

	@Id
	@Indexed(unique = true)
	private String isbn;
	private String title;
	private String author;
	private String category;

}