package bg.softuni.productshop.domain.dtos.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductBasicInfoDTO implements Serializable {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    private String sellerFirstName;

    private String sellerLastName;

    @Expose
    @SerializedName(value = "seller")
    private String sellerFullName = sellerFirstName + " " + sellerLastName;

}
