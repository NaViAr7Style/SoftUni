package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
}
