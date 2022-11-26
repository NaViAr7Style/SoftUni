import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class InStockTest {

    private ProductStock inStock;
    private Product product;

    @Before
    public void setUp() {
        this.inStock = new InStock();
        this.product = new Product("test_product", 13.00, 1);
    }

    @Test
    public void testAddInStockShouldContainThatProduct() {
        inStock.add(product);
        assertTrue(inStock.contains(product));
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductIsMissing() {
        assertFalse(inStock.contains(product));
    }

    @Test
    public void testCountShouldReturnTheCorrectNumberOfProducts() {
        assertEquals(0, inStock.getCount());
        inStock.add(product);
        assertEquals(1, inStock.getCount());
        inStock.add(new Product("test_two", 10, 13));
        assertEquals(2, inStock.getCount());
    }

    @Test
    public void testFindShouldReturnTheCorrectNthProduct() {
        List<Product> products = addMultipleProducts();

        int productIndex = 3;

        Product expected = products.get(productIndex);

        Product actual = inStock.find(productIndex);

        assertNotNull(actual);
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithIndexOutOfRangeShouldThrow() {
        List<Product> products = addMultipleProducts();
        inStock.find(products.size() + 1);
    }

    @Test
    public void testChangeQuantityShouldUpdateTheProductQuantity() {
        inStock.add(product);
        int expectedQuantity = product.getQuantity() + 13;
        inStock.changeQuantity(product.getLabel(), expectedQuantity);
        assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailIfProductWithLabelIsMissing() {
        inStock.changeQuantity("missing_label", 13);
    }

    @Test
    public void testFindByLabelShouldReturnTheProductWithTheSameLabel() {
        List<Product> products = addMultipleProducts();
        inStock.add(product);
        Product actual = inStock.findByLabel(product.getLabel());

        assertNotNull(actual);
        assertEquals(product.getLabel(), actual.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldFailWhenProductWithLabelIsMissing() {
        inStock.findByLabel("missing_label");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProducts() {
        addMultipleProducts();
        int expectedCount = 3;
        List<Product> actual = iterableToList(inStock.findFirstByAlphabeticalOrder(expectedCount));
        assertEquals(expectedCount, actual.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheProductsOrderedByLabel() {
        List<Product> expected = addMultipleProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .toList();

        int expectedCount = expected.size();

        List<Product> actual = iterableToList(inStock.findFirstByAlphabeticalOrder(expectedCount));

        assertEquals(expected, actual);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenNotEnoughProducts() {
        int size = addMultipleProducts().size();

        List<Product> products = iterableToList(inStock.findFirstByAlphabeticalOrder(size + 1));

        assertEquals(0, products.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenCountIsZero() {
        addMultipleProducts();

        List<Product> products = iterableToList(inStock.findFirstByAlphabeticalOrder(0));

        assertEquals(0, products.size());
    }

    @Test
    public void testFindAllInRangeShouldReturnTheCorrectRange() {

        final int beginRange = 2;
        final int endRange = 13;

        List<Product> expected = addMultipleProducts()
                .stream()
                .filter(p -> p.getPrice() > beginRange && p.getPrice() <= endRange)
                .toList();

        List<Product> actual = iterableToList(inStock.findAllInRange(beginRange, endRange));

        assertEquals(expected.size(), actual.size());

        boolean hasNoOutOfRangePrices = actual.stream()
                .map(Product::getPrice)
                .noneMatch(p -> p <= beginRange || p > endRange);

        assertTrue(hasNoOutOfRangePrices);
    }

    @Test
    public void testFindAllInRangeShouldReturnOrderedProductsByPriceDescending() {

        final int beginRange = 2;
        final int endRange = 13;

        List<Product> expected = addMultipleProducts()
                .stream()
                .filter(p -> p.getPrice() > beginRange && p.getPrice() <= endRange)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();

        List<Product> actual = iterableToList(inStock.findAllInRange(beginRange, endRange));

        assertEquals(expected.size(), actual.size());

        assertEquals(expected, actual);
    }

    @Test
    public void testFindAllByPriceShouldReturnMatchingPriceProducts() {
        addMultipleProducts();

        int expectedPrice = 21;
        List<Product> products = iterableToList(inStock.findAllByPrice(expectedPrice));

        for (Product product : products) {
            assertEquals(expectedPrice, product.getPrice(), 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionWhenNoneMatches() {
        addMultipleProducts();

        int expectedPrice = -21;
        List<Product> products = iterableToList(inStock.findAllByPrice(expectedPrice));

        assertEquals(0, products.size());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnTheCorrectProducts() {
        int productsToTake = 5;

        List<Product> expected = addMultipleProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(5)
                .toList();

        List<Product> actual = iterableToList(inStock.findFirstMostExpensiveProducts(productsToTake));

        assertEquals(expected.size(), actual.size());

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowWhenThereAreLessProductsInStock() {
        int size = addMultipleProducts().size();

        inStock.findFirstMostExpensiveProducts(size + 1);
    }

    @Test
    public void testFindAllByQuantityShouldReturnMatchingProducts() {
        addMultipleProducts();

        int expectedQuantity = 12;
        List<Product> products = iterableToList(inStock.findAllByQuantity(expectedQuantity));

        for (Product product : products) {
            assertEquals(expectedQuantity, product.getQuantity());
        }
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionWhenNoneMatches() {
        addMultipleProducts();

        int expectedQuantity = -21;
        List<Product> products = iterableToList(inStock.findAllByQuantity(expectedQuantity));

        assertEquals(0, products.size());
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        List<Product> expected = addMultipleProducts();

        Iterator<Product> iterator = inStock.iterator();

        List<Product> actual = new ArrayList<>();

        iterator.forEachRemaining(actual::add);

        assertEquals(expected, actual);
    }


    private List<Product> iterableToList(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }

    private List<Product> addMultipleProducts() {
        List<Product> products = List.of(
                new Product("label_6", 21, 12),
                new Product("label_4", 18, 57),
                new Product("label_1", 10, 13),
                new Product("label_7", 46, 4),
                new Product("label_8", 33, 58),
                new Product("label_3", 18, 12),
                new Product("label_5", 21, 13),
                new Product("label_2", 3, 23)
        );

        products.forEach(inStock::add);

        return products;
    }

}