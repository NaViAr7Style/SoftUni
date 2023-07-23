package bg.softuni.bookshopsystem.services.impl;

import bg.softuni.bookshopsystem.entities.Author;
import bg.softuni.bookshopsystem.entities.Book;
import bg.softuni.bookshopsystem.entities.Category;
import bg.softuni.bookshopsystem.entities.enums.AgeRestriction;
import bg.softuni.bookshopsystem.entities.enums.EditionType;
import bg.softuni.bookshopsystem.services.AuthorService;
import bg.softuni.bookshopsystem.services.BookService;
import bg.softuni.bookshopsystem.services.CategoryService;
import bg.softuni.bookshopsystem.services.SeedService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static bg.softuni.bookshopsystem.constants.FilePath.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    public SeedServiceImpl(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorService.isDataSeeded()) {
            return;
        }

        List<Author> authors = Files.readAllLines(Path.of(RESOURCE_URL + AUTHORS_FILE_NAME))
                .stream()
                .map(firstAndLastName -> {
                    String[] tokens = firstAndLastName.split("\\s+");
                    String firstName = tokens[0];
                    String lastName = tokens[1];

                    return new Author(firstName, lastName);
                })
                .toList();

        this.authorService.seedAuthors(authors);
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookService.isDataSeeded()) {
            return;
        }

        List<Book> books = Files.readAllLines(Path.of(RESOURCE_URL + BOOKS_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(row -> {
                    String[] tokens = row.split("\\s+");

                    Author author = authorService.getRandomAuthor();
                    Set<Category> categories = categoryService.getRandomCategories();

                    String title = Arrays.stream(tokens)
                            .skip(5)
                            .collect(Collectors.joining(" "));

                    EditionType edition = EditionType.values()[Integer.parseInt(tokens[0])];
                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(tokens[4])];
                    LocalDate releaseDate = LocalDate.parse(tokens[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
                    int copies = Integer.parseInt(tokens[2]);
                    BigDecimal price = new BigDecimal(tokens[3]);

                    return Book.builder()
                            .author(author)
                            .categories(categories)
                            .title(title)
                            .editionType(edition)
                            .ageRestriction(ageRestriction)
                            .releaseDate(releaseDate)
                            .copies(copies)
                            .price(price)
                            .build();
                })
                .toList();

        this.bookService.seedBooks(books);
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryService.isDataSeeded()) {
            return;
        }

        List<Category> categories = Files.readAllLines(Path.of(RESOURCE_URL + CATEGORIES_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(Category::new)
                .toList();

        this.categoryService.seedCategories(categories);
    }

}
