package com.datasystem.booksinventoryservice.infrastructure.controller;

import java.util.List;

import com.datasystem.booksinventoryservice.domain.book.model.BorrowBookRequest;
import com.datasystem.booksinventoryservice.domain.book.model.InsertNewBookRequest;
import com.datasystem.booksinventoryservice.domain.book.model.BookDto;
import com.datasystem.booksinventoryservice.domain.book.service.BookInventoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookInventoryController {

	private final BookInventoryFacade bookInventoryFacade;

	@GetMapping
	@Operation(summary = "Get all books from the inventory")
	public List<BookDto> getAllBooks() {
		return bookInventoryFacade.getAllBooks();
	}

	@PostMapping
	@Operation(summary = "Insert new book into inventory")
	public void insertNewBook(@RequestBody InsertNewBookRequest request) {
		bookInventoryFacade.insertNewBook(request);
	}

	@PutMapping
	@Operation(summary = "Borrow a book from the inventory")
	public void borrowBook(BorrowBookRequest request) {
		bookInventoryFacade.rentBook(request);
	}
}
