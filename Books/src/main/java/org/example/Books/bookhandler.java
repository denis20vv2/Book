package org.example.Books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class bookhandler {
private final databook Datebook;

    public bookhandler() {Datebook = null;}

    @GetMapping
    public List<book> get_book()
    {
     return Datebook.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<book> getAuthorById(@PathVariable Long id) {
        Optional<book> book = Datebook.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping("/create")
    public ResponseEntity<book> createbook(@RequestBody book books)
    {
        book createbook = Datebook.save(books);
        return ResponseEntity.status(HttpStatus.CREATED).body(createbook);
    }

    @DeleteMapping("/delete")
    public void deleteBook(@RequestBody book books) {
        Datebook.delete(books);
    }

    @PutMapping("/put")
    public List<book> updateBook(@RequestBody book books) {
        Datebook.save(books);
        return Datebook.findAll();
    }
}
