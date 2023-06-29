package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.entities.Category;
import bg.softuni.bookshopsystem.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Category getRandomCategory() {
        final long count = categoryRepository.count();

        if (count == 0) {
            throw new RuntimeException("No categories available in the database");
        }

        long randomId = new Random().nextLong(1L, count + 1L);

        return categoryRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

//        for (int i = 0; i < categoryRepository.count() / 2; i++) {
//            categories.add(getRandomCategory());
//        }

        categories.add(getRandomCategory());

        return categories;
    }

}
