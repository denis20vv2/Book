package com.example.books.books;

import com.example.books.books.Repos.AuthorRep;
import com.example.books.books.Repos.BookRep;
import com.example.books.books.domain.Author;
import com.example.books.books.domain.Book;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRep dateBooks;


    public BookController(BookRep dateBooks) {
        this.dateBooks = dateBooks;
    }

    /*@GetMapping
    @ResponseBody
    //public List<Book> getBook() {return (List<Book>) dateBooks.findAll();}
    public List<Book> getBook() {

        Sort sort = Sort.by(Sort.Direction.ASC, "title");

        return (List<Book>) dateBooks.findAll(sort);
    }*/

    @GetMapping
    @ResponseBody
    public List<Book> getBook() {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        List<Book> books = (List<Book>) dateBooks.findAll(sort);

        for (Book book : books) {
            Hibernate.initialize(book.getAuthors()); // Инициализируем авторов (если используете Hibernate)
        }

        return books;
    }

    @GetMapping("/home")
    @ResponseBody
    public List<Book> getFirstTenBooks() {
       Sort sort = Sort.by(Sort.Direction.ASC, "data");
       List<Book> sortedBooks = (List<Book>) dateBooks.findAll(sort);
       return sortedBooks.stream().limit(10).collect(Collectors.toList());
    }

   /* @GetMapping
    @ResponseBody
    public Page<Book> getAllTeam(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return dateBooks.Book(pageable);
    }*/


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



    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createBook = dateBooks.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
    }

}
