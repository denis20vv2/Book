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

    private final AuthorService service;



    public AuthorController(AuthorRep dataAuthors, AuthorService service) {
        this.dataAuthors = dataAuthors;
        this.service = service;
    }

   /* @GetMapping
    @ResponseBody
       // public List<Author> getAuthors() {return (List<Author>) dataAuthors.findAll();}
    public List<Author> getBook() {
        // Создаем объект сортировки по полю "title" в порядке возрастания
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        // Получаем отсортированный список книг
        return (List<Author>) dataAuthors.findAll(sort);
    }*/

    @GetMapping
    @ResponseBody
    public Page<AuthorView> getAllTournament(@PageableDefault(sort = "author_id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findAllTournament(pageable);
    }



    /*public Page<Author> getAllTeam(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findAllTeam(pageable);

   /* @GetMapping
    @ResponseBody
    public Page<Author> getAllTournament(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return dataAuthors.Author(pageable);*/

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

       /* @GetMapping("/firstName")
        public ResponseEntity<List<Author>> getAuthorsByFirstName(@RequestBody  String Name) {
            List<Author> authors = dataAuthors.findByNameContainingIgnoreCase(Name);
            if (!authors.isEmpty()) {
                return ResponseEntity.ok(authors);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

   /* @GetMapping("/search")
    public Page<Author> getAuthorsByFirstName(
            @RequestParam("Name") String Name,
            Pageable pageable) {

            return (Page<Author>) dataAuthors.getAuthorsByFirstName(Name);
        }*/



        @PostMapping
       public ResponseEntity<Author> createAuthor(@RequestBody Author authors) {
            Author createAuthor = dataAuthors.save(authors);
            return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
        }

   /* @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Author create(@RequestBody @Valid Author req) {
        return dataAuthors.save(req);
    }*/


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


