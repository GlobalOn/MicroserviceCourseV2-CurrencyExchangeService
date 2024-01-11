package com.microserviceCourse.currencyexchangeservice.controller;

import com.microserviceCourse.currencyexchangeservice.enities.CurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Environment environment;

    @Autowired
    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/{from}/{to}")
    public CurrencyRate retrieveCurrency(@PathVariable String from, @PathVariable String to){
        CurrencyRate rate = new CurrencyRate(1, from, to, 91.59, "DEV");
        String port = environment.getProperty("local.server.port");
        rate.setEnvironment(port);
        return rate;
    }
}
