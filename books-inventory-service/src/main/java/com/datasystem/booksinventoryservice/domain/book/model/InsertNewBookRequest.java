package com.datasystem.booksinventoryservice.domain.book.model;

public record InsertNewBookRequest(String title, String author, String isbn, String category) {
}
