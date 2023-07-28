package bg.softuni.productshop.domain.repositories;

import bg.softuni.productshop.domain.dtos.CategorySummaryDTO;
import bg.softuni.productshop.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM `product-shop`.categories ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Optional<Category> getRandomEntity();

    @Query(
    "SELECT " +
    "new bg.softuni.productshop.domain.dtos.CategorySummaryDTO(c.name, count(p.id), AVG(p.price), SUM(p.price)) " +
    "FROM Product AS p JOIN p.categories AS c GROUP BY c.id"
    )
    List<CategorySummaryDTO> getCategorySummary();
}
