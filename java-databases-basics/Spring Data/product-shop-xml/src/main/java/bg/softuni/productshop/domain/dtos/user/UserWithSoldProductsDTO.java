package bg.softuni.productshop.domain.dtos.user;

import bg.softuni.productshop.domain.dtos.product.ProductSoldDTO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class UserWithSoldProductsDTO implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    @SerializedName(value = "soldProducts")
    private Set<ProductSoldDTO> sellingProducts;

}
