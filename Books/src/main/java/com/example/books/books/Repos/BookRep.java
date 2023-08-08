package com.example.books.books.Repos;

import com.example.books.books.domain.Author;
import com.example.books.books.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRep extends JpaRepository<Book, Long> {


    // List<Book> getBookById(long book_id);

}
