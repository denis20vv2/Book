package com.example.books.books;

import com.example.books.books.Repos.AuthorRep;
import com.example.books.books.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/author")
public class AuthorController {

  // private final TeamService service;

        private final AuthorRep dataAuthors;





    public AuthorController(AuthorRep dataAuthors) {
        this.dataAuthors = dataAuthors;

    }

    @GetMapping
    @ResponseBody
       // public List<Author> getAuthors() {return (List<Author>) dataAuthors.findAll();}
    public List<Author> getBook() {
        // Создаем объект сортировки по полю "title" в порядке возрастания
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        // Получаем отсортированный список книг
        return (List<Author>) dataAuthors.findAll(sort);
    }





        //Поиск автора по ID
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

    //Поиск автора по имени
    // http://localhost:8080/author/search?firstName= 'Имя автора'
    @GetMapping("/search")
       @ResponseBody
        public ResponseEntity<List<Author>> searchAuthorsByFirstName(@RequestParam  String firstName) {
            List<Author> authors = dataAuthors.findByFirstName(firstName);
            if (!authors.isEmpty()) {
                return ResponseEntity.ok(authors);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

// Создание нового автора
        @PostMapping
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


