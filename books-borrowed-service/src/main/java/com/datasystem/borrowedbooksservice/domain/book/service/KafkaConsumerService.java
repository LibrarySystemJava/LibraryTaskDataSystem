package com.datasystem.borrowedbooksservice.domain.book.service;

import com.datasystem.borrowedbooksservice.domain.book.Book;
import com.datasystem.borrowedbooksservice.infrastructure.controller.CustomObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.datasystem.borrowedbooksservice.domain.book.BookRepository;
import com.datasystem.commons.events.BorrowBookEvent;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
class KafkaConsumerService {

	private final CustomObjectMapper objectMapper;
	private final BookRepository bookRepository;
	private final LibraryManagementService libraryManagementService;

	@KafkaListener(topics = "insert-book-topic", groupId = "book-management-group")
	public void receiveBookInsertEvent(String message) {
		Book book = objectMapper.readValueWithExceptionHandling(message, Book.class);
		bookRepository.save(book);
	}

	@KafkaListener(topics = "borrow-book-topic", groupId = "book-management-group")
	public void receiveBookBorrowEvent(String message) {
		BorrowBookEvent rentBookEvent = objectMapper.readValueWithExceptionHandling(message, BorrowBookEvent.class);
		libraryManagementService.borrowBook(rentBookEvent.isbn(), rentBookEvent.clientName());
	}
}
