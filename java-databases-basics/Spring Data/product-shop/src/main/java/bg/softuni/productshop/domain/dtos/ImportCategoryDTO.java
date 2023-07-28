package bg.softuni.productshop.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ImportCategoryDTO implements Serializable {

    @Expose
    private String name;

    public ImportCategoryDTO(String name) {
        this.name = name;
        validate();
    }

    private void validate() {

        if (name.length() < 3 || 15 < name.length()) {
            throw new IllegalArgumentException("Please insert a category name between 3 and 15 characters");
        }
    }


}
