package org.example.Books;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "authors")
public class authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<book> books;



    public  authors(String firstName, String lastName ){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int get_id()
    {
       return id;
    }

    public void set_id(int id){
        this.id = id;
    }

    public String get_firstName()
    {
        return firstName;
    }

    public void set_firstName(String firstName){
        this.firstName = firstName;
    }

    public String get_lastName()
    {
        return lastName;
    }

    public void set_lastName(String lastName){
        this.lastName = lastName;
    }

    public List<book> get_book()
    {
        return books;
    }

}

