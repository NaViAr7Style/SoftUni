package bg.softuni.bookshopsystem.services.impl;

import bg.softuni.bookshopsystem.entities.Book;
import bg.softuni.bookshopsystem.entities.dtos.BookPrintInfoDTO;
import bg.softuni.bookshopsystem.entities.enums.AgeRestriction;
import bg.softuni.bookshopsystem.entities.enums.EditionType;
import bg.softuni.bookshopsystem.repositories.BookRepository;
import bg.softuni.bookshopsystem.services.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return bookRepository.count() > 0;
    }

    @Override
    public void seedBooks(List<Book> books) {
        bookRepository.saveAllAndFlush(books);
    }

    @Override
    public List<Book> getAllBooksAfterYear(LocalDate date) {
        List<Book> allByReleaseDateAfter = bookRepository.findAllByReleaseDateAfter(date);

        allByReleaseDateAfter
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

        return allByReleaseDateAfter;
    }

    @Override
    public List<Book> getAllBooksBeforeYear(LocalDate date) {

        return bookRepository
                .findAllByReleaseDateBefore(date)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByAuthor(String author) {

        List<Book> allBooksByAuthor = bookRepository.findAllByAuthor(author);

        allBooksByAuthor
                .stream()
                .map(Book::getTitleReleaseDateAndCopies)
                .forEach(System.out::println);

        return allBooksByAuthor;
    }

    @Override
    public List<Book> findAllTitlesByAgeRestriction(String ageRestriction) {

        List<Book> allByAgeRestriction = bookRepository
                .findAllByAgeRestriction( AgeRestriction.valueOf(ageRestriction.toUpperCase()));

        allByAgeRestriction
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

        return allByAgeRestriction;
    }

    @Override
    public void printAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copiesCount) {

        List<Book> allByEditionTypeGoldAndCopiesLessThan = bookRepository
                .findAllByEditionTypeAndCopiesLessThan(editionType, copiesCount);

        allByEditionTypeGoldAndCopiesLessThan
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    @Override
    public void printAllBooksOutsidePriceRange(int lower, int upper) {

        List<Book> allNotBetween = bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(lower), BigDecimal.valueOf(upper));

        allNotBetween
                .stream()
                .map(Book::getTitleAndPrice)
                .forEach(System.out::println);
    }

    @Override
    public void printAllNotReleasedInYear(int year) {

        List<Book> allNotReleasedInYear = bookRepository.findAllNotReleasedInYear(year);

        allNotReleasedInYear
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

    }

    @Override
    public void printAllBeforeDate(String date) {
        int day = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int year = Integer.parseInt(date.split("-")[2]);

        LocalDate localDate = LocalDate.of(year, month, day);

        Optional<List<Book>> allByReleaseDateBefore = bookRepository.findAllByReleaseDateBefore(localDate);

        if (allByReleaseDateBefore.isEmpty()) {
            return;
        }

        allByReleaseDateBefore
                .get()
                .stream()
                .map(Book::getTitleEditionTypeAndPrice)
                .forEach(System.out::println);

    }

    @Override
    public List<Book> getAllTitlesThatContain(String regex) {

        List<Book> allByTitleContainingIgnoreCase = bookRepository.findAllByTitleContainingIgnoreCase(regex);

        allByTitleContainingIgnoreCase
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

        return allByTitleContainingIgnoreCase;
    }

    @Override
    public List<Book> getAllByAuthorLastNameStart(String regex) {

        List<Book> allByAuthorLastNameStartingWith = bookRepository.findAllByAuthorLastNameStartingWith(regex);

        allByAuthorLastNameStartingWith
                .stream()
                .map(Book::getTitleAndAuthor)
                .forEach(System.out::println);

        return allByAuthorLastNameStartingWith;
    }

    @Override
    public Integer getCountOfTitlesLongerThan(int length) {
        return bookRepository.countAllByTitleGreaterThan(length);
    }

    @Override
    public int getTotalBookCopies(String author) {
        String firstName = author.split("\\s+")[0];
        String lastName = author.split("\\s+")[1];

        return bookRepository.getTotalBookCopiesByAuthor(firstName, lastName);
    }

    @Override
    public BookPrintInfoDTO findByTitle(String title) {
        BookPrintInfoDTO byTitle = bookRepository.findByTitle(title);

        System.out.println(byTitle);

        return byTitle;
    }

    @Override
    @Transactional
    public int increaseBooksAfterDateWithCopies(String date, int copies) {
        int day = Integer.parseInt(date.split("\\s+")[0]);
        int year = Integer.parseInt(date.split("\\s+")[2]);
        int month = switch (date.split("\\s+")[1]) {
            case "Jan" -> 1;
            case "Feb" -> 2;
            case "Mar" -> 3;
            case "Apr" -> 4;
            case "May" -> 5;
            case "Jun" -> 6;
            case "Jul" -> 7;
            case "Aug" -> 8;
            case "Sep" -> 9;
            case "Oct" -> 10;
            case "Nov" -> 11;
            case "Dec" -> 12;
            default -> '0';
        };

        LocalDate localDate = LocalDate.of(year, month, day);

        List<Book> allByReleaseDateAfter = bookRepository.findAllByReleaseDateAfter(localDate);

        for (Book book : allByReleaseDateAfter) {
            book.setCopies(book.getCopies() + copies);
        }

        bookRepository.saveAllAndFlush(allByReleaseDateAfter);

        return allByReleaseDateAfter.size() * copies;
    }

    @Override
    public int deleteBooksWithCopiesLowerThan(int copies) {
        return bookRepository.deleteAllByCopiesLessThan(copies);
    }

    @Override
    public int getBooksCountByAuthorFullName(String authorFullName) {
        return bookRepository.getBooksByAuthor_AuthorFullName(authorFullName);
    }


}
