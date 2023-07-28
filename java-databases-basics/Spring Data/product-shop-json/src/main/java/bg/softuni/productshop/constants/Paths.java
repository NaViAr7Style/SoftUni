package bg.softuni.productshop.constants;

import java.nio.file.Path;

public enum Paths {
    ;

    //input files
    public static final Path USERS_JSON_PATH =
            Path.of("src", "main", "resources", "inputFiles", "jsonProcessing", "users.json");

    public static final Path CATEGORIES_JSON_PATH =
            Path.of("src", "main", "resources", "inputFiles", "jsonProcessing", "categories.json");

    public static final Path PRODUCTS_JSON_PATH =
            Path.of("src", "main", "resources", "inputFiles", "jsonProcessing", "products.json");



    //output files
    public static final Path PRODUCTS_IN_RANGE_PATH =
            Path.of("src", "main", "resources", "outputFiles", "jsonProcessing", "ProductsInRange.json");

    public static final Path CATEGORIES_BY_PRODUCTS_COUNT_PATH =
            Path.of("src", "main", "resources", "outputFiles", "jsonProcessing", "CategoriesByProductsCount.json");

    public static final Path SUCCESSFULLY_SOLD_PRODUCTS_PATH =
            Path.of("src", "main", "resources", "outputFiles", "jsonProcessing", "SuccessfullySoldProducts.json");

    public static final Path USERS_AND_PRODUCTS_PATH =
            Path.of("src", "main", "resources", "outputFiles", "jsonProcessing", "UsersAndProducts.json");



}
