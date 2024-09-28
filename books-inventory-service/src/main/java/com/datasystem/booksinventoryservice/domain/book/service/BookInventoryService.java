package com.datasystem.booksinventoryservice.domain.book.service;


import java.util.List;

import com.datasystem.booksinventoryservice.domain.book.model.BorrowBookRequest;
import com.datasystem.booksinventoryservice.domain.book.model.InsertNewBookRequest;
import com.datasystem.booksinventoryservice.domain.book.model.BookDto;

public interface BookInventoryService {

	List<BookDto> getAllBooks();

	void insertNewBook(InsertNewBookRequest request);

	void rentBook(BorrowBookRequest request);
}
