package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {

    boolean isDataSeeded();

    void seedAuthors(List<Author> authors);

    Author getRandomAuthor();

    List<Author> getAllAuthorsWithBooksBeforeGivenYear(LocalDate date);

    List<Author> getAllAuthorsOrderedByBooksDesc();
}
