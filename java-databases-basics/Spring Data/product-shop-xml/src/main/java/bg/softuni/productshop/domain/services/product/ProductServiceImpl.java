package bg.softuni.productshop.domain.services.product;

import bg.softuni.productshop.constants.Utils;
import bg.softuni.productshop.domain.dtos.product.ProductBasicInfoDTO;
import bg.softuni.productshop.domain.entities.Product;
import bg.softuni.productshop.domain.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static bg.softuni.productshop.constants.Paths.PRODUCTS_IN_RANGE_PATH;
import static bg.softuni.productshop.constants.Utils.MAPPER;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return productRepository.count() > 0;
    }

    @Override
    public void seedProducts(List<Product> products) {
        productRepository.saveAllAndFlush(products);
    }

    @Override
    public List<ProductBasicInfoDTO> getProductsInRangeWithNoBuyer(BigDecimal lowerBound,
                                                                   BigDecimal upperBound) throws IOException {
        final List<Product> products =
                productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowerBound, upperBound);

        List<ProductBasicInfoDTO> productDTOs =
                Arrays.stream(MAPPER.map(products, ProductBasicInfoDTO[].class)).toList();

        Utils.writeIntoJSONFile(productDTOs, PRODUCTS_IN_RANGE_PATH);

        return productDTOs;
    }


}
