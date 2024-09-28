package com.datasystem.borrowedbooksservice.domain.book.service;

import java.util.List;

import com.datasystem.borrowedbooksservice.domain.book.BookDto;
import org.springframework.stereotype.Service;

import com.datasystem.borrowedbooksservice.domain.book.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
class LibraryManagementServiceImpl implements LibraryManagementService {

	private final BookRepository bookRepository;

	@Override
	public List<BookDto> getAllBorrowedBooks() {
		return bookRepository.findByBorrowerIsNotNull()
				.stream()
				.map(BookMapper::mapBookToDto)
				.toList();
	}

	public void borrowBook(String isbn, String clientName) {
		bookRepository.findById(isbn).ifPresent(book -> {
			if (book.getBorrower() != null) {
				log.info("Book with isbn: [{}] is already borrowed", isbn);
				return;
			}
			book.setBorrower(clientName);
			bookRepository.save(book);
			log.info("Client [{}] successfully borrowed a book with isbn: [{}]", clientName, isbn);
		});
	}
}
