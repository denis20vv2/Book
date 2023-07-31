package org.example.Books;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dataAuthors extends JpaRepository<authors, Long> {
   // List<authors> getNameauthors(String authors);
    List<authors> findByFirstNameContainingIgnoreCaseOrderByLastName(String authors);

    List<authors> findByFirstNameContainingIgnoreCaseAndMiddleNameContainingIgnoreCase(String firstName, String lastName );
}
