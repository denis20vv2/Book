package com.example.books.books.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "authors")
public class Author {

    public static class Public { }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long author_id;
        private String firstName;
        private String lastName;



    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "author_book",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") })

    private Set<Book> Books;


    public long getId() {
        return author_id;
    }

    public void setId(int author_id) {this.author_id = author_id;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Set<Book> getBooks() {
        return Books;
    }


    public void setBooks(Set<Book> books) {
        this.Books = books;
    }

}


