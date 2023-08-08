package com.example.books.books;

import com.example.books.books.Repos.AuthorRep;
import com.example.books.books.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorService {

    private final AuthorToAuthorViewConverter tournamentToTournamentViewConverter;
    private final AuthorRep tournamentRepo;



    public AuthorService(AuthorRep tournamentRepo, AuthorToAuthorViewConverter tournamentToTournamentViewConverter) {
        this.tournamentRepo = tournamentRepo;
        this.tournamentToTournamentViewConverter = tournamentToTournamentViewConverter;
    }

    public Page<AuthorView> findAllTournament(Pageable pageable){
        Page<Author> tournaments = tournamentRepo.findAll(pageable);
        List<AuthorView> tournamentViews = new ArrayList<>();
        tournaments.forEach(tournament -> {
            AuthorView tournamentView = tournamentToTournamentViewConverter.convert(tournament);
            tournamentViews.add(tournamentView);
        });
        return new PageImpl<>(tournamentViews, pageable, tournaments.getTotalElements());
    }

}
