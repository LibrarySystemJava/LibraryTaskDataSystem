package com.datasystem.borrowedbooksservice.domain.book.service;

import com.datasystem.borrowedbooksservice.domain.book.Book;
import com.datasystem.borrowedbooksservice.domain.book.BookDto;

class BookMapper {

    private BookMapper() {
    }

    public static BookDto mapBookToDto(Book book) {
        return new BookDto(
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getBorrower()
        );
    }

}