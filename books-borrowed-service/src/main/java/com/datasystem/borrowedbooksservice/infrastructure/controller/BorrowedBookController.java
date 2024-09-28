package com.datasystem.borrowedbooksservice.infrastructure.controller;

import java.util.List;

import com.datasystem.borrowedbooksservice.domain.book.BookDto;
import com.datasystem.borrowedbooksservice.domain.book.service.LibraryFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
class BorrowedBookController {

	private final LibraryFacade libraryFacade;

	@GetMapping("/book")
	@Operation(summary = "Get all borrowed books")
	public List<BookDto> getAllBorrowedBooks() {
		return libraryFacade.getAllBorrowedBooks();
	}

}
