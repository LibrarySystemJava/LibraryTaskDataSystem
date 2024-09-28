package com.datasystem.borrowedbooksservice.domain.book.service;

import com.datasystem.borrowedbooksservice.domain.book.BookDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LibraryFacade {

    private final LibraryManagementService libraryManagementService;

    public List<BookDto> getAllBorrowedBooks() {
        return libraryManagementService.getAllBorrowedBooks();
    }

}
