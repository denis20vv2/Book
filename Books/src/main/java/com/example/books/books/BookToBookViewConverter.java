package com.example.books.books;

import com.example.books.books.domain.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BookToBookViewConverter implements Converter<Book, BookView> {

    @Override
    public BookView convert(@NonNull Book team) {
        BookView view = new BookView();
        view.setBook_id(team.getId());
        view.setTitle(team.getTitle());
        view.setData(team.getData());
        return view;
    }

}
