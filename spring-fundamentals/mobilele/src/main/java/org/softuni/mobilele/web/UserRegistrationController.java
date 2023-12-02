package org.softuni.mobilele.web;

import org.softuni.mobilele.models.dtos.ReCaptchaResponseDTO;
import org.softuni.mobilele.models.dtos.UserRegistrationDTO;
import org.softuni.mobilele.services.interfaces.ReCaptchaService;
import org.softuni.mobilele.services.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;
    private final ReCaptchaService reCaptchaService;

    public UserRegistrationController(UserService userService,
                                      ReCaptchaService reCaptchaService) {
        this.userService = userService;
        this.reCaptchaService = reCaptchaService;
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO,
                           @RequestParam("g-recaptcha-response") String reCaptchaResponse) {

        boolean isRealUser = reCaptchaService
                .verify(reCaptchaResponse)
                .map(ReCaptchaResponseDTO::isSuccess)
                .orElse(false);

        if (!isRealUser) {
            return "redirect:/";
        }

        userService.registerUser(userRegistrationDTO);

        return "redirect:/";
    }
}
