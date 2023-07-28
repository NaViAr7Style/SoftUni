package bg.softuni.productshop.domain.services.category;

import bg.softuni.productshop.domain.dtos.CategorySummaryDTO;
import bg.softuni.productshop.domain.entities.Category;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    boolean isDataSeeded();

    void seedCategories(List<Category> categories);

    long getCount();

    Optional<Category> getRandomEntity();

    List<CategorySummaryDTO> getCategorySummary() throws IOException;
}
