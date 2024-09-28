package com.datasystem.booksinventoryservice.domain.book.service;

import com.datasystem.booksinventoryservice.domain.book.model.BookDto;
import com.datasystem.booksinventoryservice.domain.book.model.BorrowBookRequest;
import com.datasystem.booksinventoryservice.domain.book.model.InsertNewBookRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BookInventoryFacade {

    private final BookInventoryService bookInventoryService;

    public List<BookDto> getAllBooks(){
        return bookInventoryService.getAllBooks();
    }

    public void insertNewBook(InsertNewBookRequest request) {
        bookInventoryService.insertNewBook(request);
    }

    public void rentBook(BorrowBookRequest request) {
        bookInventoryService.rentBook(request);
    }

}
