package bg.softuni.productshop.domain.dtos.user;

import bg.softuni.productshop.domain.dtos.product.ProductsSoldWithCountDTO;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserWithSoldProductsDTO2 {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private ProductsSoldWithCountDTO soldProducts;
}
