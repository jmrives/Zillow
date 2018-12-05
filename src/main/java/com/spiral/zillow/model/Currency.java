package com.spiral.zillow.model;

import com.spiral.zillow.model.converter.CurrencyConverter;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class Currency {

    @XStreamAsAttribute
    private String currency;
    private Integer amount;

    public String getCurrency() {
        return currency;
    }

    public Currency() { }

    public Currency(Integer amount) {
        this.amount = amount;
    }

    public Currency(String currency, Integer amount) {
        this.amount = amount;
        this.currency = currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
