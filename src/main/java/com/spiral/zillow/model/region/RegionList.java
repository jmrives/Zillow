package com.spiral.zillow.model.region;

import com.spiral.zillow.model.ModelClass;

import java.util.List;

public class RegionList extends ModelClass {
    private Integer count;
    private List<Region> regions;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

}
