package org.softuni.mobilele.web;

import org.junit.jupiter.api.Test;
import org.softuni.mobilele.testUtils.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestData testData;

    @Test
    void testConvert() throws Exception {

        testData.createExchangeRate("EUR", BigDecimal.valueOf(0.51));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/currency/convert")
                        .param("target", "EUR")
                        .param("amount", "1000")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.currency", is("EUR")))
                .andExpect(jsonPath("$.amount", is(510.0)));


    }

}