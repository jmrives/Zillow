package com.spiral.zillow.model;

public class LocalRealEstate extends ModelClass {
    private RealEstateRegion region;

    public LocalRealEstate() {}

    public RealEstateRegion getRegion() {
        return region;
    }

    public void setRegion(RealEstateRegion region) {
        this.region = region;
    }
}
