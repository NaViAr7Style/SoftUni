package bg.softuni.productshop.domain.services.category;

import bg.softuni.productshop.constants.Utils;
import bg.softuni.productshop.domain.dtos.category.CategorySummaryDTO;
import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.domain.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static bg.softuni.productshop.constants.Paths.CATEGORIES_BY_PRODUCTS_COUNT_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return categoryRepository.count() > 0;
    }

    @Override
    public void seedCategories(List<Category> categories) {
        categoryRepository.saveAllAndFlush(categories);
    }

    @Override
    public long getCount() {
        return categoryRepository.count();
    }

    @Override
    public Optional<Category> getRandomEntity() {
        return categoryRepository.getRandomEntity();
    }

    @Override
    public List<CategorySummaryDTO> getCategorySummary() throws IOException {
        final List<CategorySummaryDTO> categorySummary= categoryRepository.getCategorySummary();

        Utils.writeIntoJSONFile(categorySummary, CATEGORIES_BY_PRODUCTS_COUNT_PATH);

        return categorySummary;
    }
}
