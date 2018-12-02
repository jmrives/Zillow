package com.spiral.zillow.model.search;

import com.spiral.zillow.model.*;

public class Result extends ModelClass {
    private String zpid;
    private ResultLinks links;
    private Address address;
    private Zestimate zestimate;
    private RealEstate localRealEstate;
    private Zestimate rentZestimate;

    public Result() {}

    public String getZpid() {
        return zpid;
    }

    public void setZpid(String zpId) {
        this.zpid = zpId;
    }

    public ResultLinks getLinks() {
        return links;
    }

    public void setLinks(ResultLinks links) {
        this.links = links;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Zestimate getZestimate() {
        return zestimate;
    }

    public void setZestimate(Zestimate zestimate) {
        this.zestimate = zestimate;
    }

    public RealEstate getLocalRealEstate() {
        return localRealEstate;
    }

    public void setLocalRealEstate(RealEstate localRealEstate) {
        this.localRealEstate = localRealEstate;
    }

    public Zestimate getRentZestimate() {
        return rentZestimate;
    }

    public void setRentZestimate(Zestimate rentZestimate) {
        this.rentZestimate = rentZestimate;
    }
}
