package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.entities.Author;
import bg.softuni.bookshopsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author AS a ORDER BY SIZE(a.books)")
    Optional<List<Author>> findAllDistinctOrderByBookSize();

}
