package org.softuni.mobilele.models.dtos;

public record UserRegistrationDTO(String firstName,
                                  String lastName,
                                  String email,
                                  String password,
                                  String confirmPassword) {

}
