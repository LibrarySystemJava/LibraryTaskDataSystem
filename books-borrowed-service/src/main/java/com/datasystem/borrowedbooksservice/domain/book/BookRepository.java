package com.datasystem.borrowedbooksservice.domain.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findByBorrowerIsNotNull();

}
