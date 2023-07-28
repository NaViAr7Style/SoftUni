package bg.softuni.gamestore.domain.services.user;

import bg.softuni.gamestore.domain.dtos.UserLoginDTO;
import bg.softuni.gamestore.domain.dtos.UserRegisterDTO;
import bg.softuni.gamestore.domain.entities.User;
import bg.softuni.gamestore.domain.repositories.UserRepository;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static bg.softuni.gamestore.constants.ErrorMessages.*;

@Getter
@Service
public class UserServiceImpl implements UserService {

    private User loggedInUser;

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    public String registerUser(String[] args) {
        final int argsLength = args.length;

        final String email = argsLength > 1 ? args[1] : "";
        final String password = argsLength > 2 ? args[2] : "";
        final String confirmPassword = argsLength > 3 ? args[3] : "";
        final String fullName = argsLength > 4 ? args[4] : "";

        UserRegisterDTO userRegisterDto;

        try {
            userRegisterDto = new UserRegisterDTO(email, password, confirmPassword, fullName);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        Optional<User> firstByEmail = userRepository.findFirstByEmail(email);

        if (firstByEmail.isPresent()) {
            return EMAIL_IN_USE;
        }

        User user = modelMapper.map(userRegisterDto, User.class);
        user.setIsAdmin(userRepository.count() == 0);
        userRepository.saveAndFlush(user);

        return userRegisterDto.successfullyRegisteredUser();
    }

    @Override
    public String loginUser(String[] args) {
        if (this.loggedInUser != null) {
            return ALREADY_LOGGED;
        }

        final int argsLength = args.length;

        final String email = argsLength > 1 ? args[1] : "";
        final String password = argsLength > 2 ? args[2] : "";

        final Optional<User> userToBeLogged = userRepository.findFirstByEmail(email);

        if (userToBeLogged.isEmpty()) {
            return INVALID_USERNAME_OR_PASSWORD;
        }

        final UserLoginDTO userLoginDto = new UserLoginDTO(email, password);

        try {
            userLoginDto.validate(userToBeLogged.get().getPassword());
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        this.loggedInUser = userToBeLogged.get();

        return userLoginDto.successfullyLogged();
    }

    @Override
    public String logoutUser() {
        if (this.loggedInUser == null) {
            return NO_LOGGED_USER;
        }

        String username = this.loggedInUser.getFullName();
        this.loggedInUser = null;
        return String.format("User %s successfully logged out", username);
    }

    @Override
    public boolean userIsNotAdmin() {
        return this.loggedInUser == null || !this.loggedInUser.getIsAdmin();
    }

}
