package bg.softuni.productshop.domain.services.seed;

import bg.softuni.productshop.domain.dtos.ImportCategoryDTO;
import bg.softuni.productshop.domain.dtos.ImportProductDTO;
import bg.softuni.productshop.domain.dtos.ImportUserDTO;
import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.domain.entities.Product;
import bg.softuni.productshop.domain.entities.User;
import bg.softuni.productshop.domain.services.category.CategoryService;
import bg.softuni.productshop.domain.services.product.ProductService;
import bg.softuni.productshop.domain.services.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.LongStream;

import static bg.softuni.productshop.constants.Paths.*;
import static bg.softuni.productshop.constants.Utils.GSON;
import static bg.softuni.productshop.constants.Utils.MAPPER;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public SeedServiceImpl(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    @Transactional
    public void seedUsers() throws IOException {
        if (userService.isDataSeeded()) {
            return;
        }

        FileReader fileReader = new FileReader(USERS_JSON_PATH.toFile());

        ImportUserDTO[] userDTOS = GSON.fromJson(fileReader, ImportUserDTO[].class);
        User[] usersToSave = MAPPER.map(userDTOS, User[].class);
        userService.seedUsers(Arrays.stream(usersToSave).toList());

        fileReader.close();
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryService.isDataSeeded()) {
            return;
        }

        FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH.toFile());

        ImportCategoryDTO[] categoryDTOs = GSON.fromJson(fileReader, ImportCategoryDTO[].class);
        Category[] categoriesToSave = MAPPER.map(categoryDTOs, Category[].class);
        categoryService.seedCategories(Arrays.stream(categoriesToSave).toList());

        fileReader.close();
    }

    @Override
    @Transactional
    public void seedProducts() throws IOException {
        if (productService.isDataSeeded()) {
            return;
        }

        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

        List<Product> productsToSave = Arrays.stream(GSON.fromJson(fileReader, ImportProductDTO[].class))
                .map(productDto -> MAPPER.map(productDto, Product.class))
                .map(this::setRandomCategories)
                .map(this::setRandomBuyer)
                .map(this::getRandomSeller)
                .toList();

        productService.seedProducts(productsToSave);

        fileReader.close();
    }

    private Product getRandomSeller(Product product) {
        User randomUser = userService.getRandomEntity().orElseThrow(NoSuchElementException::new);

        if (product.getBuyer() != null) {

            while (Objects.equals(product.getBuyer().getId(), randomUser.getId())) {
                randomUser = userService.getRandomEntity().orElseThrow(NoSuchElementException::new);
            }

        }

        product.setSeller(randomUser);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(750L)) > 0) {
            return product;
        }

        User randomUser = userService.getRandomEntity().orElseThrow(NoSuchElementException::new);

        product.setBuyer(randomUser);

        return product;
    }

    private Product setRandomCategories(Product product) {
        final Random rand = new Random();

        long countOfCategories = rand.nextLong(this.categoryService.getCount());

        Set<Category> categories = new HashSet<>();

        LongStream.range(0L, countOfCategories)
                .forEach(value ->
                        categories
                                .add(categoryService
                                        .getRandomEntity()
                                        .orElseThrow(NoSuchElementException::new)));

        product.setCategories(categories);

        return product;
    }

}
