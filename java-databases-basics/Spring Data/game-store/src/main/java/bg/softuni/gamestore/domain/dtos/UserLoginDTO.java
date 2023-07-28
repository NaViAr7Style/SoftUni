package bg.softuni.gamestore.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static bg.softuni.gamestore.constants.ErrorMessages.PASS_MISMATCH;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDTO {

    private String email;
    private String password;

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void validate(String correctPassword) {
        if (!this.password.equals(correctPassword)) {
            throw new IllegalArgumentException(PASS_MISMATCH);
        }
    }

    public String successfullyLogged() {
        return String.format("Successfully logged " + email);
    }
}
