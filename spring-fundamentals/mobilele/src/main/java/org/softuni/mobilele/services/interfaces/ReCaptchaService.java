package org.softuni.mobilele.services.interfaces;

import org.softuni.mobilele.models.dtos.ReCaptchaResponseDTO;

import java.util.Optional;

public interface ReCaptchaService {

    Optional<ReCaptchaResponseDTO> verify(String token);
}
