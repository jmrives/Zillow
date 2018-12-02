package com.spiral.zillow.model.chart;

import com.spiral.zillow.model.ModelClass;

public class ChartLinks extends ModelClass {
    private String forSale;
    private String forSaleByOwner;

    public ChartLinks() { }

    public ChartLinks(String forSale, String forSaleByOwner) {
        this.forSale = forSale;
        this.forSaleByOwner = forSaleByOwner;
    }

    public String getForSale() {
        return forSale;
    }

    public void setForSale(String forSale) {
        this.forSale = forSale;
    }

    public String getForSaleByOwner() {
        return forSaleByOwner;
    }

    public void setForSaleByOwner(String forSaleByOwner) {
        this.forSaleByOwner = forSaleByOwner;
    }
}
