package bg.softuni.productshop.domain.services.product;

import bg.softuni.productshop.domain.dtos.ProductBasicInfoDTO;
import bg.softuni.productshop.domain.entities.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    boolean isDataSeeded();

    void seedProducts(List<Product> products);

    List<ProductBasicInfoDTO> getProductsInRangeWithNoBuyer(BigDecimal lowerBound, BigDecimal upperBound) throws IOException;
}
