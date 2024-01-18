package com.microserviceCourse.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sampleAPI() {
        logger.info("Sample API call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8000/random-api", String.class);
//        return forEntity.getBody();
        return "Bulkhead restricts calls to 3";
    }

    //Fallback method have to have Throwable as an argument,
    //That`s why we placed ex obj as a param
    public String hardcodedResponse(Exception ex) {
        logger.info("Exception thrown from " +  this.getClass().getSimpleName() + " " + ex);
        return "/sample-api resource currently unavailable, please try again later";
    }
}
