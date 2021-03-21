package com.zhitar.currencyconversionservice.controller;

import com.zhitar.currencyconversionservice.dto.CurrencyDto;
import com.zhitar.currencyconversionservice.dto.ExchangeDto;
import com.zhitar.currencyconversionservice.service.CurrencyExchangeClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class CurrencyConversionController {

    private static final String EXCHANGE_SERVICE_URL = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
    private final RestTemplate restTemplate;

    private final CurrencyExchangeClient feignExchangeClient;

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyDto convertCurrency(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        ExchangeDto exchangeDto = restTemplate.getForObject(
                EXCHANGE_SERVICE_URL, ExchangeDto.class, from, to);
        return map(Objects.requireNonNull(exchangeDto), quantity);
    }

    @GetMapping("feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyDto convertCurrencyFeign(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        ExchangeDto exchangeDto = feignExchangeClient.convertCurrency(from, to);
        return map(exchangeDto, quantity);
    }

    private CurrencyDto map(ExchangeDto exchangeDto, BigDecimal quantity) {
        return new CurrencyDto(
                exchangeDto.getId(),
                exchangeDto.getFrom(),
                exchangeDto.getTo(),
                exchangeDto.getConversionMultiple(),
                quantity,
                exchangeDto.getConversionMultiple().multiply(quantity)
        );
    }


}
