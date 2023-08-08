package com.example.books.books;

import com.example.books.books.domain.Author;
import com.example.books.books.domain.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class AuthorToAuthorViewConverter implements Converter<Author, AuthorView> {

    private final BookToBookViewConverter bookTobookViewConverter;

    public AuthorToAuthorViewConverter(BookToBookViewConverter teamToTeamViewConverter) {
        this.bookTobookViewConverter = teamToTeamViewConverter;
    }

    @Override
    public AuthorView convert(@NonNull Author author) {
        AuthorView view = new AuthorView();
        view.setAuthor_id(author.getId());
        view.setFirstName(author.getFirstName());
        view.setLastName(author.getLastName());
        Set<BookView> views = new HashSet<>();
        Set<Book> books= author.getBooks();
        books.forEach(book -> views.add(bookTobookViewConverter.convert(book)));
        view.setTeams(views);
        return view;
    }


}
