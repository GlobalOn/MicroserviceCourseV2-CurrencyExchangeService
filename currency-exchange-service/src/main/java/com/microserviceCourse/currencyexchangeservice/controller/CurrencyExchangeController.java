package com.microserviceCourse.currencyexchangeservice.controller;

import com.microserviceCourse.currencyexchangeservice.enities.CurrencyRate;
import com.microserviceCourse.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class CurrencyExchangeController {

    private Environment environment;
    private CurrencyExchangeRepository repository;

    @Autowired
    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @GetMapping("/currency-exchange/{from}/{to}")
    public CurrencyRate retrieveCurrency(@PathVariable String from, @PathVariable String to) throws SQLException {
        CurrencyRate USDtoRUBrate = repository.findByFromAndTo(from, to);
        if (USDtoRUBrate == null) {
            throw new RuntimeException("Unable to find currency rate for " + from + " to " + to);
        }
        String port = environment.getProperty("local.server.port");
        USDtoRUBrate.setEnvironment(port);
        return USDtoRUBrate;
    }
}
