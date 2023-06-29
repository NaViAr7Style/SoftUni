package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.entities.Author;
import bg.softuni.bookshopsystem.entities.Book;
import bg.softuni.bookshopsystem.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookService bookService;

    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    @Override
    public boolean isDataSeeded() {
        return authorRepository.count() > 0;
    }

    @Override
    public void seedAuthors(List<Author> authors) {
        authorRepository.saveAllAndFlush(authors);
    }

    @Override
    public Author getRandomAuthor() {
        final long count = authorRepository.count();

        if (count == 0) {
            throw new RuntimeException("No authors available in the database");
        }

        long randomId = new Random().nextLong(1L, count + 1L);

        return authorRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Author> getAllAuthorsWithBooksBeforeGivenYear(LocalDate date) {
        List<Author> authorList = bookService
                .getAllBooksBeforeYear(date)
                .stream()
                .map(Book::getAuthor)
                .toList();

        authorList
                .stream()
                .map(Author::getAuthorFullName)
                .forEach(System.out::println);

        return authorList;
    }

    @Override
    @Transactional
    public List<Author> getAllAuthorsOrderedByBooksDesc() {
        final List<Author> authors = authorRepository
                .findAllDistinctOrderByBookSize()
                .orElseThrow(NoSuchElementException::new);

        authors
                .stream()
                .map(Author::getFullNameAndCountOfBooks)
                .forEach(System.out::println);

        return authors;
    }

}
