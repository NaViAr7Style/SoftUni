package bg.softuni.productshop;

import bg.softuni.productshop.domain.services.category.CategoryService;
import bg.softuni.productshop.domain.services.product.ProductService;
import bg.softuni.productshop.domain.services.seed.SeedService;
import bg.softuni.productshop.domain.services.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws IOException {
        seedService.seedData();

        productService.getProductsInRangeWithNoBuyer(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        userService.getSuccUsers();

        categoryService.getCategorySummary();

        userService.getSuccUsers2();
    }

}
