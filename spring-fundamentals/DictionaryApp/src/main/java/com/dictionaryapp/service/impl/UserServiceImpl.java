package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.user.UserLoginDTO;
import com.dictionaryapp.model.dto.user.UserRegisterDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           LoggedUser loggedUser,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegisterDTO userRegisterDTO) {

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return false;
        }

        boolean userExists = userRepository
                .existsByUsernameOrEmail(userRegisterDTO.getUsername(), userRegisterDTO.getEmail());

        if (userExists) {
            return false;
        }

        User newUser = map(userRegisterDTO);

        userRepository.save(newUser);

        return true;
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();

        User user = userRepository.findByUsername(username);

        if (user != null && passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {

            loggedUser.login(username);
            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }

    private User map(UserRegisterDTO userRegisterDTO) {
        User user = new User();

        user.setUsername(userRegisterDTO.getUsername());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        return user;
    }
}
