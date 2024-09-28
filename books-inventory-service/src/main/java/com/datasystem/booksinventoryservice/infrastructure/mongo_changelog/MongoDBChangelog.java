package com.datasystem.booksinventoryservice.infrastructure.mongo_changelog;

import java.util.List;

import com.datasystem.booksinventoryservice.domain.book.Book;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMongock
@ChangeLog(order = "001")
public class MongoDBChangelog {

	@ChangeSet(order = "001", id = "insert-example-books", author = "michal-k")
	public void insertBooks(MongockTemplate mongockTemplate) {
		mongockTemplate.insertAll(List.of(
				new Book("978-8308057011", "Pan Tadeusz", "Adam Mickiewicz", "Poematy epickie"),
				new Book("978-8375108741", "Lalka", "Bolesław Prus", "Powieść"),
				new Book("978-0345803481", "50 twarzy Greya", "E.L. James", "Romans"),
				new Book("978-0140447941", "Zbrodnia i kara", "Fiodor Dostojewski", "Powieść"),
				new Book("978-8324588186", "Wiedźmin: Ostatnie życzenie", "Andrzej Sapkowski", "Fantasy")
		));
	}
}
