package org.softuni.mobilele.services;

public interface EmailService {

    void sendRegistrationEmail(String userEmail, String userFullName);
}
