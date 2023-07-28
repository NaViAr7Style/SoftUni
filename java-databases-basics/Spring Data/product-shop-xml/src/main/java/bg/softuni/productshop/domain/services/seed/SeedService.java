package bg.softuni.productshop.domain.services.seed;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface SeedService {


    void seedUsers(String type) throws IOException, JAXBException;

    void seedCategories(String type) throws IOException, JAXBException;

    void seedProducts(String type) throws IOException, JAXBException;

    default void seedData(String type) throws IOException, JAXBException {
        seedCategories(type);
        seedUsers(type);
        seedProducts(type);
    }
}
