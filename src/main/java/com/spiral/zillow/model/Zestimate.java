package com.spiral.zillow.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Zestimate extends ModelClass {
    private String amount;
    @XStreamAlias("last-updated")
    private String lastUpdated;
    private String oneWeekChange;
    private String valueChange;
    private ValuationRange valuationRange;
    private String percentile;

    public Zestimate() {}

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getOneWeekChange() {
        return oneWeekChange;
    }

    public void setOneWeekChange(String oneWeekChange) {
        this.oneWeekChange = oneWeekChange;
    }

    public String getValueChange() {
        return valueChange;
    }

    public void setValueChange(String valueChange) {
        this.valueChange = valueChange;
    }

    public ValuationRange getValuationRange() {
        return valuationRange;
    }

    public void setValuationRange(ValuationRange valuationRange) {
        this.valuationRange = valuationRange;
    }

    public String getPercentile() {
        return percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
    }
}
