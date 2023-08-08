package com.example.books.books.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long book_id;
    private String title;

    private Date data;

   /* @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "AuthorBook",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})*/
    //private Set<Author> Authors = new HashSet<>();

    //private Date Created;

   /* @ManyToOne
    @JoinColumn(name = "author_id")
    private Author Author;

    public book() {
        this.timeCreated = new Date();
    }*/

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

  /*  public Set<Author> getAuthors() {
        return Authors;
    }

   // public void setAuthors(Set<Author> authors) {
        Authors = authors;
    }*/
}



