package org.example.Books;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    private Date timeCreated;

   @ManyToOne
    @JoinColumn(name = "author_id")
    private authors Author;

    public book() {
        this.timeCreated = new Date();
    }

   public book(int id,String title){
       this.id=id ;
       this.title=title;
       this.timeCreated = new Date();

   }

    public int get_id()
    {
        return id;
    }

    public void set_id(int id){
        this.id = id;
    }


    public String get_title()
    {
        return title;
    }

    public void set_title(String title){
        this.title = title;
    }

    public authors get_author()
    {
        return Author;
    }

    public void set_author(authors Author){
        this.Author = Author;
    }
}



