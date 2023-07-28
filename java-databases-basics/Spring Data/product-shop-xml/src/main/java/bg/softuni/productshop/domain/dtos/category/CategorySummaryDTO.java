package bg.softuni.productshop.domain.dtos.category;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategorySummaryDTO {

    @Expose
    private String category;

    @Expose
    private Long productsCount;

    @Expose
    private Double averagePrice;

    @Expose
    private BigDecimal totalRevenue;
}
