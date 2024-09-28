package com.datasystem.borrowedbooksservice.domain.book.service;

import java.util.List;

import com.datasystem.borrowedbooksservice.domain.book.BookDto;

interface LibraryManagementService {

	List<BookDto> getAllBorrowedBooks();

	void borrowBook(String isbn, String clientName);
}
