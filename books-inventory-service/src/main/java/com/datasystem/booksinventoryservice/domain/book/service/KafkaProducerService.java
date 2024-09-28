package com.datasystem.booksinventoryservice.domain.book.service;

import com.datasystem.booksinventoryservice.domain.book.Book;
import com.datasystem.commons.events.BorrowBookEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	@Value("${library.topics.insert-book}")
	private String insertBookTopic;

	@Value("${library.topics.borrow-book}")
	private String borrowBookTopic;

	public void sendBookInsertEvent(Book book) {
		kafkaTemplate.send(insertBookTopic, book);
	}

	public void sendBookBorrowEvent(BorrowBookEvent rentBookRequest) {
		kafkaTemplate.send(borrowBookTopic, rentBookRequest);
	}
}
