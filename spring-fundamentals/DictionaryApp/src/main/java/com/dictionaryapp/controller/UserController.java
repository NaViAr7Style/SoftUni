package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.user.UserLoginDTO;
import com.dictionaryapp.model.dto.user.UserRegisterDTO;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService,
                          LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginDTO") UserLoginDTO userLoginDTO) {

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginDTO") @Valid UserLoginDTO userLoginDTO,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }

        boolean isLoggedSuccessfully = userService.login(userLoginDTO);

        if (!isLoggedSuccessfully) {
            ModelAndView modelAndView = new ModelAndView("login");

            modelAndView.addObject("hasLoginError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterDTO") UserRegisterDTO userRegisterDTO) {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterDTO") @Valid UserRegisterDTO userRegisterDTO,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        boolean isRegisteredSuccessfully = userService.register(userRegisterDTO);

        if (!isRegisteredSuccessfully) {
            ModelAndView modelAndView = new ModelAndView("register");

            modelAndView.addObject("hasRegistrationError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        loggedUser.logout();

        return new ModelAndView("redirect:/");
    }

}
