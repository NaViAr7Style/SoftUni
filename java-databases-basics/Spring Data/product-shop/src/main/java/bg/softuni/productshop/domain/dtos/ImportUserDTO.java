package bg.softuni.productshop.domain.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ImportUserDTO implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    public ImportUserDTO(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        validate();
    }

    private void validate() {

        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name is too short!");
        }
    }

}
