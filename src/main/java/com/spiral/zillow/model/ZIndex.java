package com.spiral.zillow.model;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class ZIndex  extends ModelClass {

    @XStreamAsAttribute
    private String currency;

    public ZIndex(String currency) {
        this.currency = currency;
    }

}
