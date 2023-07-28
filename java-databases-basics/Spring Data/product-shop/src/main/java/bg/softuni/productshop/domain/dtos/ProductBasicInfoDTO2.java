package bg.softuni.productshop.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductBasicInfoDTO2 {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

}
