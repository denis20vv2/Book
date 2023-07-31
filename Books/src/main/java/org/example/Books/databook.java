package org.example.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface databook extends JpaRepository <book, Long>
{
    List<book> findByTitleContainingIgnoreCaseOrderByTitleAsc(String search);
    List<book> findAllByOrderByTitleAsc();
    List<book> findTop10ByOrderByCreatedAtDesc();
    List<book> findByAuthor(authors author);
}
