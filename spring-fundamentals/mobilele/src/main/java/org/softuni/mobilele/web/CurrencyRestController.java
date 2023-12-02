package org.softuni.mobilele.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Converts BGN to a target currency.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Returned when we successfully converted the currency.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MoneyDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Returned when there is no information about the requested currency.",
                    content = @Content
            )
    })
    @Parameter(name = "target", description = "The target currency to which to convert the BGN amount.", required = true)
    @Parameter(name = "amount", description = "The amount in BGN to be converted to the target currency.", required = true)
    @GetMapping("/api/currency/convert")
    public MoneyDTO convert(@Valid ConvertRequestDTO convertRequestDTO) {
        return currencyService.convert(convertRequestDTO);
    }

}
