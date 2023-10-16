package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.dtos.UserRegistrationDTO;
import org.softuni.mobilele.models.entities.User;
import org.softuni.mobilele.repositories.UserRepository;
import org.softuni.mobilele.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map((userRegistrationDTO)));
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
