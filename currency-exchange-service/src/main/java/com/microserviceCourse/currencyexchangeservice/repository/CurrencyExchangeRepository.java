package com.microserviceCourse.currencyexchangeservice.repository;

import com.microserviceCourse.currencyexchangeservice.enities.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyRate, Integer> {

    CurrencyRate findByFromAndTo(String from, String to);
}
