 create table author_book (
       author_id int8 not null,
        book_id int8 not null,
        primary key (author_id, book_id)
    )


    create table authors (
       author_id  bigserial not null,
        first_name varchar(255),
        last_name varchar(255),
        primary key (author_id)
    )


    create table books (
       book_id  bigserial not null,
        title varchar(255),
        date timestamp,
        primary key (book_id)
    )


    alter table author_book
       add constraint FKmeehr164a2cpxegeiawuv40a3
       foreign key (book_id)
       references books


    alter table author_book
       add constraint FK7cqs8nb7l859jcwwqoawcokqf
       foreign key (author_id)
       references authors
