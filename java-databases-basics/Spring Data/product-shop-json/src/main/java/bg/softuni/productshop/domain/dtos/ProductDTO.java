package bg.softuni.productshop.domain.dtos;

import bg.softuni.productshop.domain.entities.User;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductDTO {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private User buyer;

    @Expose
    private User seller;

    @Expose
    private Set<CategoryDTO> categories;


    public static ProductsSoldWithCountDTO toProductSoldWithCountDTO(Set<ProductDTO> soldProducts) {
        List<ProductBasicInfoDTO2> products =
                soldProducts.stream().map(ProductDTO::toProductBasicInfoDTO2).toList();

        return ProductsSoldWithCountDTO.productsSoldWithCountDTO(products);
    }

    private static ProductBasicInfoDTO2 toProductBasicInfoDTO2(ProductDTO productDTO) {
        return new ProductBasicInfoDTO2(productDTO.getName(), productDTO.getPrice());
    }
}
