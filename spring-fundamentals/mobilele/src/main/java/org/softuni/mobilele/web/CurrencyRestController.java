package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.models.dtos.ConvertRequestDTO;
import org.softuni.mobilele.models.dtos.MoneyDTO;
import org.softuni.mobilele.services.interfaces.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyRestController {

    private final CurrencyService currencyService;

    public CurrencyRestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/api/currency/convert")
    public MoneyDTO convert(@Valid ConvertRequestDTO convertRequestDTO) {
        return currencyService.convert(convertRequestDTO);
    }

}
