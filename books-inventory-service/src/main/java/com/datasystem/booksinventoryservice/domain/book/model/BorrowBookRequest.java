package com.datasystem.booksinventoryservice.domain.book.model;

public record BorrowBookRequest(String isbn,String clientName) {
}
