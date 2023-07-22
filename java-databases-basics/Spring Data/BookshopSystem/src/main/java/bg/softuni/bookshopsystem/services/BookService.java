package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    boolean isDataSeeded();

    void seedBooks(List<Book> books);

    List<Book> getAllBooksAfterYear(LocalDate date);

    List<Book> getAllBooksBeforeYear(LocalDate date);

    List<Book> findAllByAuthor(String author);
}
