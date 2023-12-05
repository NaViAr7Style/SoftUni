package com.plannerapp.model.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class UserRegisterBindingModel extends UserLoginBindingModel {

    @Email
    @NotBlank(message = "Email cannot be empty!")
    private String email;

    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


}