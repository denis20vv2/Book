package com.example.books.books;

import com.example.books.books.Repos.AuthorRep;
import com.example.books.books.domain.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/author")
public class AuthorController {


        private final AuthorRep dataAuthors;

    public AuthorController(AuthorRep dataAuthors) {
        this.dataAuthors = dataAuthors;
    }

    @GetMapping
    @ResponseBody
        public List<Author> getAuthors() {
            return (List<Author>) dataAuthors.findAll();
        }

        @GetMapping("/{id}")
        @ResponseBody
        public ResponseEntity<Author> getAuthorById(@PathVariable long id) {
            Optional<Author> author = dataAuthors.findById(id);
            if (author.isPresent()) {
                return ResponseEntity.ok(author.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/search")
        public ResponseEntity<List<Author>> getAuthorsByFirstName(@RequestBody String firstName, String lastName) {
            List<Author> authors = dataAuthors.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
            if (!authors.isEmpty()) {
                return ResponseEntity.ok(authors);
            } else {
                return ResponseEntity.notFound().build();
            }
        }




        @PostMapping("/create")
       public ResponseEntity<Author> createAuthor(@RequestBody Author authors) {
            Author createAuthor = dataAuthors.save(authors);
            return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
        }



        @DeleteMapping("/delete")
        public void deleteAuthor(@RequestBody Author authors) {
            dataAuthors.delete(authors);
        }

        @PutMapping("/put")
        public List<Author> updateAuthor(@RequestBody Author authors) {
            dataAuthors.save(authors);
            return (List<Author>) dataAuthors.findAll();
        }
    }


