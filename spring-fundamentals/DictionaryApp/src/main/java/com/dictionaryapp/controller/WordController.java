package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.AddWordDTO;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordController {

    private final WordService wordService;
    private final LoggedUser loggedUser;

    public WordController(WordService wordService,
                          LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/words/add")
    public ModelAndView addWord(@ModelAttribute("addWordDTO") AddWordDTO addWordDTO) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("word-add");
    }

    @PostMapping("/words/add")
    public ModelAndView addWord(@ModelAttribute("addWordDTO") @Valid AddWordDTO addWordDTO,
                                BindingResult bindingResult) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("word-add");
        }

        wordService.addWord(addWordDTO);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/home/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        wordService.remove(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home/remove-all")
    public ModelAndView remove() {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        wordService.removeAll();

        return new ModelAndView("redirect:/home");
    }

}
