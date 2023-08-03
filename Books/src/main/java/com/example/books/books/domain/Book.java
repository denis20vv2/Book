package com.example.books.books.domain;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;

    //private Date Created;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author Author;

   /* public book() {
        this.timeCreated = new Date();
    }*/

    public Book(long id, String title){
        this.id=id ;
        this.title=title;
       // this.timeCreated = new Date();

    }

    public long getId()
    {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Author getAuthor()
    {
        return Author;
    }

    public void setAuthor(Author Author){
        this.Author = Author;
    }
}



