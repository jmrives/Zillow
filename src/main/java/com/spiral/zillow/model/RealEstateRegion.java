package com.spiral.zillow.model;

public class RealEstateRegion extends ModelClass {
    private String zindexValue;
    private RealEstateLinks links;

    public RealEstateRegion() {}

    public String getZindexValue() {
        return zindexValue;
    }

    public void setZindexValue(String zindexValue) {
        this.zindexValue = zindexValue;
    }

    public RealEstateLinks getRealEstateLinks() {
        return links;
    }

    public void setRealEstateLinks(RealEstateLinks realEstateLinks) {
        this.links = realEstateLinks;
    }
}
