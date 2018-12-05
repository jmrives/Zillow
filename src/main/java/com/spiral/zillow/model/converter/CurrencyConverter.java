package com.spiral.zillow.model.converter;

import com.spiral.zillow.model.Currency;
import com.thoughtworks.xstream.converters.SingleValueConverter;

public class CurrencyConverter implements SingleValueConverter {

    public String toString(Object obj) {
        return Integer.toString(((Currency) obj).getAmount());
    }

    public Object fromString(String name) {
        return new Currency(Integer.parseInt(name));
    }

    public boolean canConvert(Class type) {
        return type.equals(Currency.class);
    }

}
