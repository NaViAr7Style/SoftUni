package bg.softuni.gamestore.domain.services.user;

import bg.softuni.gamestore.domain.entities.User;

public interface UserService {

    String registerUser(String[] args);

    String loginUser(String[] args);

    String logoutUser();

    boolean userIsNotAdmin();

    User getLoggedInUser();
}
