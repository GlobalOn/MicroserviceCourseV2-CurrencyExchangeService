package com.microserviceCourse.currencyexchangeservice.enities;


public class CurrencyRate {

    private int id;
    private String from;
    private String to;
    private double conversionMultiple;
    private String environment;

    public CurrencyRate() {
    }

    public CurrencyRate(int id, String from, String to, double conversionMultiple, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public double getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(double conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}
