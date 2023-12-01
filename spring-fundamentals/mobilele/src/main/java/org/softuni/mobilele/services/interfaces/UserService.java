package org.softuni.mobilele.services.interfaces;

import org.softuni.mobilele.models.dtos.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);
}
