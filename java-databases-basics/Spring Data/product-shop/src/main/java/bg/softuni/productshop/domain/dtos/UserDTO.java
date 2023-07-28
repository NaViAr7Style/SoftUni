package bg.softuni.productshop.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private Set<ProductDTO> soldProducts;

    public UserWithSoldProductsDTO2 toUserWithSoldProductsDTO2() {
        return new UserWithSoldProductsDTO2(firstName, lastName, age, ProductDTO.toProductSoldWithCountDTO(soldProducts));
    }
}
