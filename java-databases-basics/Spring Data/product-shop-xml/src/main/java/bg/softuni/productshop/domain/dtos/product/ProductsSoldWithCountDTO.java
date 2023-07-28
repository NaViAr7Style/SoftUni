package bg.softuni.productshop.domain.dtos.product;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductsSoldWithCountDTO {

    @Expose
    private Integer count;

    @Expose
    private List<ProductBasicInfoDTO2> products;

    public static ProductsSoldWithCountDTO productsSoldWithCountDTO(List<ProductBasicInfoDTO2> products) {
        return new ProductsSoldWithCountDTO(products.size(), products);
    }
}
