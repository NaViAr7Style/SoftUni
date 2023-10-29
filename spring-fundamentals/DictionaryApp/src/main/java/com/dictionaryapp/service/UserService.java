package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.user.UserLoginDTO;
import com.dictionaryapp.model.dto.user.UserRegisterDTO;

public interface UserService {

    boolean register(UserRegisterDTO userRegisterDTO);

    boolean login(UserLoginDTO userLoginDTO);

    void logout();
}
