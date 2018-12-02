package com.spiral.zillow.model;

public class ValuationRange extends ModelClass {
    private String low;
    private String high;

    public ValuationRange() {}

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }
}
