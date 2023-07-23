package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.entities.enums.EditionType;
import bg.softuni.bookshopsystem.services.AuthorService;
import bg.softuni.bookshopsystem.services.BookService;
import bg.softuni.bookshopsystem.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

//        bookService.findAllTitlesByAgeRestriction("miNor");
//        bookService.printAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000);
//        bookService.printAllBooksOutsidePriceRange(5, 40);
//        bookService.printAllNotReleasedInYear(2000);
//        bookService.printAllBeforeDate("12-04-1992");
//        authorService.findAllByFirstNameEndingWith("dy");
//        bookService.getAllTitlesThatContain("sK");
//        bookService.getAllByAuthorLastNameStart("Ric");
//        System.out.println(bookService.getCountOfTitlesLongerThan(40));
//        System.out.println(bookService.getTotalBookCopies("Randy Graham"));
//        bookService.findByTitle("Things Fall Apart");
//        System.out.println(bookService.increaseBooksAfterDateWithCopies("06 Jun 2013", 44));
//        System.out.println(bookService.deleteBooksWithCopiesLowerThan(1000));


//        PROCEDURE for Problem. 14

//        DELIMITER $$
//        CREATE PROCEDURE usp_get_authors_total_books(
//                IN author_full_name VARCHAR(255),
//                OUT totalBooksWritten INT
//        )
//        BEGIN
//        SELECT COUNT(*)
//        INTO totalBooksWritten
//        FROM books AS b
//        JOIN authors AS a ON a.id = b.author_id
//        WHERE CONCAT(a.first_name, ' ', a.last_name) = author_full_name;
//        END$$
//                DELIMITER ;
//        ;

//        String authorName = "Amanda Rice";
//        int booksWritten = bookService.getBooksCountByAuthorFullName("Amanda Rice");
//        System.out.printf("%s has written %d books\n", authorName, booksWritten);





    }

}
