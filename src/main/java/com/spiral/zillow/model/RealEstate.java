package com.spiral.zillow.model;

public class RealEstate extends ModelClass {
    private RealEstateRegion region;

    public RealEstate() {}

    public RealEstateRegion getRegion() {
        return region;
    }

    public void setRegion(RealEstateRegion region) {
        this.region = region;
    }
}
