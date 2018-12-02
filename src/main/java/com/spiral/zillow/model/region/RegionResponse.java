package com.spiral.zillow.model.region;

import com.spiral.zillow.model.Response;

public class RegionResponse extends Response {
    private Region region;
    private RegionList list;
    private String subregiontype;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public RegionList getList() {
        return list;
    }

    public void setList(RegionList list) {
        this.list = list;
    }

    public String getSubregiontype() {
        return subregiontype;
    }

    public void setSubregiontype(String subregiontype) {
        this.subregiontype = subregiontype;
    }
}
