package bg.softuni.productshop.domain.dtos.product;

import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.domain.entities.User;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class ImportProductDTO implements Serializable {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private User buyer;

    @Expose
    private User seller;

    @Expose
    private Set<Category> categories;

    public ImportProductDTO(String name, BigDecimal price, User buyer, User seller, Set<Category> categories) {
        this.name = name;
        this.price = price;
        this.buyer = buyer;
        this.seller = seller;
        this.categories = categories;
        validate();
    }

    private void validate() {

        if (name.length() < 3) {
            throw new IllegalArgumentException("Product name is too short!");
        }
    }
}
