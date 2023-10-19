package org.softuni.mobilele.services;

import org.softuni.mobilele.models.dtos.UserLoginDTO;
import org.softuni.mobilele.models.dtos.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
