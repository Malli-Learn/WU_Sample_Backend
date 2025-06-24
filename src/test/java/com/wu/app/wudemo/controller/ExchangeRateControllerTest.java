package com.wu.app.wudemo.controller;

import com.wu.app.wudemo.service.ExchangeRateService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExchangeRateController.class)
class ExchangeRateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ExchangeRateService exchangeRateService;

    @Test
    void testGetExchangeRateSuccess() throws Exception {
        Mockito.when(exchangeRateService.getExchangeRate("USD", "INR"))
                .thenReturn(new BigDecimal("86.63"));

        mockMvc.perform(get("/exchange-rate")
                        .param("from", "USD")
                        .param("to", "INR"))
                .andExpect(status().isOk())
                .andExpect(content().string("86.63"));
    }

    @Test
    void testGetExchangeRateNotFound() throws Exception {
        Mockito.when(exchangeRateService.getExchangeRate("XYZ", "INR"))
                .thenThrow(new RuntimeException("Exchange rate not available"));

        mockMvc.perform(get("/exchange-rate")
                        .param("from", "XYZ")
                        .param("to", "INR"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Exchange rate not available"));
    }
}
