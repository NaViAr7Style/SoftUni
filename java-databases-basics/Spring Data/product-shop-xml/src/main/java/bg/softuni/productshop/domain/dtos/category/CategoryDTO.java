package bg.softuni.productshop.domain.dtos.category;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    @Expose
    private String name;

}
