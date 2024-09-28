package com.datasystem.borrowedbooksservice.domain.book;


public record BookDto(
        String isbn,
        String title,
        String author,
        String category,
        String borrower
) {
}