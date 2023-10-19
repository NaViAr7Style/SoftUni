package org.softuni.mobilele.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
@Getter
@Setter
public class CurrentUser {

    private String firstName;

    private String lastName;

    private boolean isLogged;

    public void logout() {
        setLogged(false);
        setFirstName(null);
        setLastName(null);
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();

        if (firstName != null) {
            sb.append(firstName);
        }

        if (lastName != null) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }

            sb.append(lastName);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isLogged=" + isLogged +
                '}';
    }
}
