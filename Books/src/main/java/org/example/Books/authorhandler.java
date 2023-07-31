package org.example.Books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class authorhandler {
    private final dataAuthors dataAuthors;

    public authorhandler(org.example.Books.dataAuthors dataAuthors) {
        this.dataAuthors = dataAuthors;
    }


    @GetMapping
    public List<authors> getAuthors() {
        return dataAuthors.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<authors> getAuthorById(@PathVariable Long id) {
        Optional<authors> author = dataAuthors.findById(id);
        if (author.isPresent()) {
            return ResponseEntity.ok(author.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping("/search")
    public ResponseEntity<List<authors>> getAuthorsByFirstName(@RequestBody String firstName, String lastName) {
        List<authors> authors = dataAuthors.findByFirstNameContainingIgnoreCaseAndMiddleNameContainingIgnoreCase(firstName, lastName);
        if (!authors.isEmpty()) {
            return ResponseEntity.ok(authors);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/




    @PostMapping("/create")
    public ResponseEntity<authors> createAuthor(@RequestBody authors authors) {
        authors createAuthor = dataAuthors.save(authors);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
    }


    @DeleteMapping("/delete")
    public void deleteAuthor(@RequestBody authors authors) {
        dataAuthors.delete(authors);
    }

    @PutMapping("/put")
    public List<authors> updateAuthor(@RequestBody authors authors) {
        dataAuthors.save(authors);
        return dataAuthors.findAll();
    }
}
