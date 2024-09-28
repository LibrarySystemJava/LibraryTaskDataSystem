package com.datasystem.commons.events;

public record BorrowBookEvent(String isbn, String clientName) {
}
