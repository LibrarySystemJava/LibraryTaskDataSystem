package com.datasystem.borrowedbooksservice.domain.book.service;

import com.datasystem.borrowedbooksservice.domain.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class LibraryFacadeConfiguration {

    private final BookRepository bookRepository;

    @Bean
    LibraryFacade libraryFacade() {
        LibraryManagementService libraryManagementService = new LibraryManagementServiceImpl(bookRepository);
        return new LibraryFacade(libraryManagementService);
    }

}
