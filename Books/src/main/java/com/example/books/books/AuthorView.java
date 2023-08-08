package com.example.books.books;

import java.io.Serializable;
import java.util.Set;

   public class AuthorView implements Serializable {

        private Long author_id;

        private String firstName;

        private String lastName;

        private Set<BookView> teams;


       public Long getAuthor_id() {
           return author_id;
       }

       public void setAuthor_id(Long author_id) {
           this.author_id = author_id;
       }

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

       public Set<BookView> getTeams() {
           return teams;
       }

       public void setTeams(Set<BookView> teams) {
           this.teams = teams;
       }
   }
