package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.entities.Book;
import bg.softuni.bookshopsystem.entities.dtos.BookPrintInfoDTO;
import bg.softuni.bookshopsystem.entities.enums.EditionType;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    boolean isDataSeeded();

    void seedBooks(List<Book> books);

    List<Book> getAllBooksAfterYear(LocalDate date);

    List<Book> getAllBooksBeforeYear(LocalDate date);

    List<Book> findAllByAuthor(String author);

    List<Book> findAllTitlesByAgeRestriction(String ageRestriction);

    void printAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copiesCount);

    void printAllBooksOutsidePriceRange(int lower, int upper);

    void printAllNotReleasedInYear(int year);

    void printAllBeforeDate(String date);

    List<Book> getAllTitlesThatContain(String regex);

    List<Book> getAllByAuthorLastNameStart(String regex);

    Integer getCountOfTitlesLongerThan(int length);

    int getTotalBookCopies(String author);

    BookPrintInfoDTO findByTitle(String title);

    int increaseBooksAfterDateWithCopies(String date, int copies);

    int deleteBooksWithCopiesLowerThan(int copies);

    int getBooksCountByAuthorFullName(String authorFullName);
}
