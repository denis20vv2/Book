package com.example.books.books;

import com.example.books.books.Repos.AuthorRep;
import com.example.books.books.Repos.BookRep;
import com.example.books.books.domain.Author;
import com.example.books.books.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRep dateBooks;


    public BookController(BookRep dateBooks) {
        this.dateBooks = dateBooks;
    }

    @GetMapping
    @ResponseBody
    public List<Book> getBook() {
        return (List<Book>) dateBooks.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Optional<Book> Book = dateBooks.findById(id);
        if (Book.isPresent()) {
            return ResponseEntity.ok(Book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    /*@PostMapping("/create")
    public ResponseEntity<Book> createAuthor(@RequestBody Book book) {
        Author createAuthor = dateBooks.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
    }*/

}
