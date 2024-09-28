package com.datasystem.booksinventoryservice.domain.book.service;

import java.util.List;

import com.datasystem.booksinventoryservice.domain.book.Book;
import com.datasystem.booksinventoryservice.domain.book.model.InsertNewBookRequest;
import com.datasystem.booksinventoryservice.domain.book.model.BookDto;

class BookMapper {

	private BookMapper() {
	}

	public static List<BookDto> mapToDt5o(List<Book> books) {
		return books.stream()
				.map(BookMapper::mapToDto)
				.toList();
	}

	public static BookDto mapToDto(Book book) {
		return new BookDto(
				book.getTitle(),
				book.getAuthor(),
				book.getIsbn(),
				book.getCategory()
		);
	}

	public static Book mapToDto(InsertNewBookRequest bookRequest) {
		return new Book(
				bookRequest.isbn(),
				bookRequest.title(),
				bookRequest.author(),
				bookRequest.category()
		);
	}
}