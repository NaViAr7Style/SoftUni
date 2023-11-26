package org.softuni.mobilele.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "user_activation_codes")
@Getter
@Setter
public class UserActivationCodeEntity extends BaseEntity {

    private String activationCode;

    private Instant created;

    @ManyToOne
    private UserEntity user;


}
