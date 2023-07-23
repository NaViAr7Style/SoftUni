package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.entities.Book;
import bg.softuni.bookshopsystem.entities.dtos.BookPrintInfoDTO;
import bg.softuni.bookshopsystem.entities.enums.AgeRestriction;
import bg.softuni.bookshopsystem.entities.enums.EditionType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

    @Query ("SELECT b FROM Book AS b " +
            "WHERE CONCAT(b.author.firstName, ' ', b.author.lastName) = :author " +
            "ORDER BY b.releaseDate DESC, b.title")
    List<Book> findAllByAuthor(String author);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    @Query ("SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) != :year")
    List<Book> findAllNotReleasedInYear(int year);

    List<Book> findAllByTitleContainingIgnoreCase(String regex);

    List<Book> findAllByAuthorLastNameStartingWith(String regex);

    @Query ("SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title) > :length")
    Integer countAllByTitleGreaterThan(int length);

    @Query ("SELECT SUM(b.copies) FROM Book AS b WHERE b.author.firstName = :firstName AND b.author.lastName = :lastName")
    Integer getTotalBookCopiesByAuthor(String firstName, String lastName);

    @Query ("SELECT new bg.softuni" +
                        ".bookshopsystem" +
                        ".entities" +
                        ".dtos" +
                        ".BookPrintInfoDTO(b.title, b.editionType, b.ageRestriction, b.price) " +
            "FROM Book AS b " +
            "WHERE b.title = :title")
    BookPrintInfoDTO findByTitle(String title);

    @Transactional
    @Modifying
    int deleteAllByCopiesLessThan(int copies);

    @Procedure(value = "usp_get_authors_total_books")
    int getBooksByAuthor_AuthorFullName (String authorName);
}
