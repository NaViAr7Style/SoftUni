package bg.softuni.gamestore.domain.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Pattern;

import static bg.softuni.gamestore.constants.ErrorMessages.*;
import static bg.softuni.gamestore.constants.Validations.EMAIL_PATTERN;
import static bg.softuni.gamestore.constants.Validations.PASSWORD_PATTERN;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserRegisterDTO {

    private String email;

    private String password;

    private String confirmPassword;

    private String fullName;

    public UserRegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        validate();
    }

    private void validate() {

        if (!Pattern.matches(EMAIL_PATTERN, this.email)) {
            throw new IllegalArgumentException(INVALID_EMAIL);
        }

        if (!Pattern.matches(PASSWORD_PATTERN, this.password)) {
            throw new IllegalArgumentException(INVALID_PASSWORD);
        }

        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException(PASS_MISMATCH);
        }
    }

    public String successfullyRegisteredUser() {
        return fullName + " was registered.";
    }
}
