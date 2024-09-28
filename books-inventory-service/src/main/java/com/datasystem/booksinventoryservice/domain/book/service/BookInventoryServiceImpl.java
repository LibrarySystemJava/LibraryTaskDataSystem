package com.datasystem.booksinventoryservice.domain.book.service;

import java.util.List;

import com.datasystem.booksinventoryservice.domain.book.Book;
import com.datasystem.booksinventoryservice.domain.book.model.BorrowBookRequest;
import com.datasystem.booksinventoryservice.domain.book.model.InsertNewBookRequest;
import com.datasystem.booksinventoryservice.domain.book.model.BookDto;
import com.datasystem.booksinventoryservice.domain.book.BookRepository;
import com.datasystem.commons.events.BorrowBookEvent;
import org.springframework.stereotype.Service;

import com.datasystem.booksinventoryservice.infrastructure.exception.BookNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.datasystem.booksinventoryservice.domain.book.service.BookMapper.mapToDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookInventoryServiceImpl implements BookInventoryService {

	private final BookRepository bookRepository;
	private final KafkaProducerService kafkaProducerService;

	@Override
	public List<BookDto> getAllBooks() {
		return bookRepository.findAll()
				.stream()
				.map(BookMapper::mapToDto)
				.toList();
	}

	@Override
	public void insertNewBook(InsertNewBookRequest request) {
		Book book = mapToDto(request);
		bookRepository.save(book);
		kafkaProducerService.sendBookInsertEvent(book);
		log.info("Book with title [{}] and ISBN [{}] insertion event sent", request.title(), request.isbn());
	}

	@Override
	public void rentBook(BorrowBookRequest request) {
		bookRepository.findById(request.isbn()).orElseThrow(() -> new BookNotFoundException(request.isbn()));
		kafkaProducerService.sendBookBorrowEvent(new BorrowBookEvent(request.isbn(), request.clientName()));
		log.info("Borrow event sent for book with ISBN [{}] for client [{}] ", request.isbn(),request.clientName());
	}
}
