package com.example.books.books.Repos;

import com.example.books.books.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRep extends CrudRepository<Author, Long> {

    List<Author> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);
}
