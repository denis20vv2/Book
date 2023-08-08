package com.example.books.books.Repos;

import com.example.books.books.domain.Author;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AuthorRep extends JpaRepository<Author, Long> {

  //  List<Author> findByNameContainingIgnoreCase(String firstName);



}
