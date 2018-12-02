package com.spiral.zillow.model;

public class RealEstateLinks extends ModelClass {

    private String overview;
    private String forSaleByOwner;
    private String forSale;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getForSaleByOwner() {
        return forSaleByOwner;
    }

    public void setForSaleByOwner(String forSaleByOwner) {
        this.forSaleByOwner = forSaleByOwner;
    }

    public String getForSale() {
        return forSale;
    }

    public void setForSale(String forSale) {
        this.forSale = forSale;
    }
}
