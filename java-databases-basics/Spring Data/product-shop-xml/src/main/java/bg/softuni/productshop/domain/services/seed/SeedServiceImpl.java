package bg.softuni.productshop.domain.services.seed;

import bg.softuni.productshop.domain.dtos.category.ImportCategoryDTO;
import bg.softuni.productshop.domain.dtos.category.wrappers.ImportCategoryWrapperDTO;
import bg.softuni.productshop.domain.dtos.product.ProductBasicInfoDTO2;
import bg.softuni.productshop.domain.dtos.product.wrappers.ImportProductWrapperDTO;
import bg.softuni.productshop.domain.dtos.user.ImportUserDTO;
import bg.softuni.productshop.domain.dtos.user.wrappers.ImportUserWrapperDTO;
import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.domain.entities.Product;
import bg.softuni.productshop.domain.entities.User;
import bg.softuni.productshop.domain.services.category.CategoryService;
import bg.softuni.productshop.domain.services.product.ProductService;
import bg.softuni.productshop.domain.services.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
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
    public void seedUsers(String type) throws IOException, JAXBException {
        if (userService.isDataSeeded()) {
            return;
        }

        final List<User> usersToSave = type.equals("JSON")
                ? getAllUsersFromJSON()
                : getAllUsersFromXML();

        userService.seedUsers(usersToSave);
    }

    @Override
    public void seedCategories(String type) throws IOException, JAXBException {
        if (categoryService.isDataSeeded()) {
            return;
        }

        final List<Category> categoriesToSave = type.equals("JSON")
                ? getAllCategoriesFromJSON()
                : getAllCategoriesFromXML();

        categoryService.seedCategories(categoriesToSave);
    }

    @Override
    @Transactional
    public void seedProducts(String type) throws IOException, JAXBException {
        if (productService.isDataSeeded()) {
            return;
        }

        final List<Product> productsToSave = type.equals("JSON")
                ? getAllProductsFromJSON()
                : getAllProductsFromXML();

        productService.seedProducts(productsToSave);
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

    private List<Category> getAllCategoriesFromJSON() throws IOException {
        FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH.toFile());

        ImportCategoryDTO[] categoryDTOs = GSON.fromJson(fileReader, ImportCategoryDTO[].class);
        List<Category> categoryList = Arrays.stream(MAPPER.map(categoryDTOs, Category[].class)).toList();

        fileReader.close();
        return categoryList;
    }

    private List<Category> getAllCategoriesFromXML() throws IOException, JAXBException {
        FileReader fileReader = new FileReader(CATEGORIES_XML_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(ImportCategoryWrapperDTO.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final ImportCategoryWrapperDTO importWrapperDTO = (ImportCategoryWrapperDTO) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        return importWrapperDTO
                .getCategories()
                .stream()
                .map(importCategoryDTO -> MAPPER.map(importCategoryDTO, Category.class))
                .toList();
    }

    private List<User> getAllUsersFromJSON() throws IOException {
        FileReader fileReader = new FileReader(USERS_JSON_PATH.toFile());

        ImportUserDTO[] userDTOS = GSON.fromJson(fileReader, ImportUserDTO[].class);
        final List<User> userList = Arrays.stream(MAPPER.map(userDTOS, User[].class)).toList();
        
        fileReader.close();
        return userList;
    }

    private List<User> getAllUsersFromXML() throws IOException, JAXBException {
        FileReader fileReader = new FileReader(USERS_XML_PATH.toFile());

        JAXBContext context = JAXBContext.newInstance(ImportUserWrapperDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ImportUserWrapperDTO wrapperDTO = (ImportUserWrapperDTO) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        return wrapperDTO
                .getUsers()
                .stream()
                .map(importUserDTO -> MAPPER.map(importUserDTO, User.class))
                .toList();
    }

    private List<Product> getAllProductsFromJSON() throws IOException {
        FileReader fileReader = new FileReader(PRODUCTS_XML_PATH.toFile());

        ProductBasicInfoDTO2[] productDTOs = GSON.fromJson(fileReader, ProductBasicInfoDTO2[].class);
        final List<Product> productList = Arrays.stream(MAPPER.map(productDTOs, Product[].class)).toList();

        fileReader.close();
        return productList;
    }

    private List<Product> getAllProductsFromXML() throws IOException, JAXBException {
        FileReader fileReader = new FileReader(PRODUCTS_XML_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(ImportProductWrapperDTO.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final ImportProductWrapperDTO importWrapperDTO = (ImportProductWrapperDTO) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        return importWrapperDTO
                .getProducts()
                .stream()
                .map(importProductDTO -> MAPPER.map(importProductDTO, Product.class))
                .map(this::setRandomCategories)
                .map(this::setRandomBuyer)
                .map(this::getRandomSeller)
                .toList();
    }

}
