package com.example.books.books.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    public static class Public { }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long book_id;
    private String title;

    private Date data;


    @ManyToMany(mappedBy= "Books")
    @JsonIgnoreProperties("books")
    private Set<Author> authors;

   public Book() {
       this.data = new Date();
   }
    public Book(long book_id, String title, Date data){
        this.book_id=book_id ;
        this.title=title;
        this.data = new Date();

    }

    public Date getData() {
        return data;
    }

   public void setData(Date data) {
        this.data = data;
    }

    public long getId() {
        return book_id;
    }

    public void setId(int book_id) {
        this.book_id = book_id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }


    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}



