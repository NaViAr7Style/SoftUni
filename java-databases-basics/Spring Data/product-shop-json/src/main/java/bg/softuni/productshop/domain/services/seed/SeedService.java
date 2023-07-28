package bg.softuni.productshop.domain.services.seed;

import java.io.IOException;

public interface SeedService {


    void seedUsers() throws IOException;

    void seedCategories() throws IOException;

    void seedProducts() throws IOException;

    default void seedData() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
