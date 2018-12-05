package com.spiral.zillow.model.region;

import com.spiral.zillow.model.ModelClass;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

public class RegionList extends ModelClass {

    private Integer count;

    @XStreamImplicit
    private List<Region> regions = new ArrayList<Region>();

    public void add(Region region) {
        if (null == regions) {
            regions = new ArrayList<Region>();
        }

        regions.add(region);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

}
