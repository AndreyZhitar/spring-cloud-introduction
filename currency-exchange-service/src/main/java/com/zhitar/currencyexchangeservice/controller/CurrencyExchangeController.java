package com.zhitar.currencyexchangeservice.controller;

import com.zhitar.currencyexchangeservice.domain.Exchange;
import com.zhitar.currencyexchangeservice.repository.ExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeRepository exchangeRepository;

    @GetMapping("from/{from}/to/{to}")
    public Exchange getExchange(@PathVariable String from, @PathVariable String to) {
        Exchange exchange = exchangeRepository.findByFromEqualsAndToEquals(from, to).orElseThrow(IllegalArgumentException::new);
        exchange.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        return exchange;
    }
}
