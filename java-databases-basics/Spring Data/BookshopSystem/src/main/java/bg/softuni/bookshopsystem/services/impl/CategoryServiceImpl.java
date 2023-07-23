package bg.softuni.bookshopsystem.services.impl;

import bg.softuni.bookshopsystem.entities.Category;
import bg.softuni.bookshopsystem.repositories.CategoryRepository;
import bg.softuni.bookshopsystem.services.CategoryService;
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

//        Theoretically, this code should work and books should have various number of categories between 1 and 4.
//        However, for some reason we are able to add multiple references to the same category object
//        within a Set collection, which causes an error.
//
//        for (long i = 0; i < categoryRepository.count() / 2; i++) {
//            categories.add(getRandomCategory());
//        }

        //Adding only one category per book as the for loop throws an error.
        categories.add(getRandomCategory());

        return categories;
    }

}
