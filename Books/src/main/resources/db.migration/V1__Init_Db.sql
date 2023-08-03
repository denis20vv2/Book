create table authors (
       authors_id int8 not null,
        first_name varchar(255),
        last_name varchar(255),
        primary key (authors_id)
    )

create table books (
       books_id int8 not null,
       author_id int8 NOT NULL
        title varchar(255),
        primary key (books_id)

    )

   CREATE TABLE AuthorBook (
          id int8 PRIMARY KEY,
          authors_id Long NOT NULL REFERENCES authors,
          books_id   long NOT NULL REFERENCES books,
          UNIQUE (authors_id, books_id)
   );