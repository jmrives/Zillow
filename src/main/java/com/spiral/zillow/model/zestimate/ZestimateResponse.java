package com.spiral.zillow.model.zestimate;

import com.spiral.zillow.model.*;

public class ZestimateResponse extends Response {

    private Integer zpid;
    private ResultLinks links;
    private Address address;
    private Zestimate zestimate;
    private Zestimate rentzestimate;
    private RealEstate localRealEstate;
    private Regions regions;

    public Integer getZpid() {
        return zpid;
    }

    public void setZpid(Integer zpid) {
        this.zpid = zpid;
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

    public Zestimate getRentzestimate() {
        return rentzestimate;
    }

    public void setRentzestimate(Zestimate rentzestimate) {
        this.rentzestimate = rentzestimate;
    }

    public RealEstate getLocalRealEstate() {
        return localRealEstate;
    }

    public void setLocalRealEstate(RealEstate localRealEstate) {
        this.localRealEstate = localRealEstate;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }
}
