package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.entities.Book;
import bg.softuni.bookshopsystem.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

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

}
