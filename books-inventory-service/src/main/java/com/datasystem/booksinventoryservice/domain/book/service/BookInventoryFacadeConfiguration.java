package com.datasystem.booksinventoryservice.domain.book.service;

import com.datasystem.booksinventoryservice.domain.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BookInventoryFacadeConfiguration {

    private final BookRepository bookRepository;
    private final KafkaProducerService kafkaProducerService;

    @Bean
    BookInventoryFacade bookInventoryFacade() {
        BookInventoryService bookInventoryService = new BookInventoryServiceImpl(bookRepository,kafkaProducerService);
        return new BookInventoryFacade(bookInventoryService);
    }

}
