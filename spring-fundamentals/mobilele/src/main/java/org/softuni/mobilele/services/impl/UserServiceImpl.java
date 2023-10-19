package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.dtos.UserLoginDTO;
import org.softuni.mobilele.models.dtos.UserRegistrationDTO;
import org.softuni.mobilele.models.entities.User;
import org.softuni.mobilele.repositories.UserRepository;
import org.softuni.mobilele.services.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map((userRegistrationDTO)));
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        User user = userRepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

        boolean loginSuccess = false;

        if (user != null) {
            String rawPass = userLoginDTO.password();
            String encodedPass = user.getPassword();

            loginSuccess = encodedPass != null &&
                    passwordEncoder.matches(rawPass, encodedPass);

            if (loginSuccess) {
                currentUser.setLogged(true);
                currentUser.setFirstName(user.getFirstName());
                currentUser.setLastName(user.getLastName());
            } else {
                currentUser.logout();
            }
        }

        return loginSuccess;
    }

    @Override
    public void logoutUser() {
        currentUser.logout();
    }

    private User map(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();

        user.setActive(true);
        user.setFirstName(userRegistrationDTO.firstName());
        user.setLastName(userRegistrationDTO.lastName());
        user.setEmail(userRegistrationDTO.email());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

        return user;
    }

}
