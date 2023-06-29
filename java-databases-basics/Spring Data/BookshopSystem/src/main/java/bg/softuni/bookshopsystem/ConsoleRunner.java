package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.services.AuthorService;
import bg.softuni.bookshopsystem.services.BookService;
import bg.softuni.bookshopsystem.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService service, BookService bookService, AuthorService authorService) {
        this.seedService = service;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAllData();

//        System.out.println(bookService.getAllBooksAfterYear(LocalDate.of(2000, 1, 1)).size());

//        authorService.getAllAuthorsWithBooksBeforeGivenYear(LocalDate.of(1990, 1, 1));

        System.out.println(authorService.getAllAuthorsOrderedByBooksDesc().size());
    }

}
