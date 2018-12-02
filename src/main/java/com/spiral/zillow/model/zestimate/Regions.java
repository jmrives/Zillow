package com.spiral.zillow.model.zestimate;

import com.spiral.zillow.model.ModelClass;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Regions extends ModelClass {

    @XStreamAlias("zipcode-id")
    private Integer zipcodeId;
    @XStreamAlias("city-id")
    private Integer cityId;
    @XStreamAlias("county-id")
    private Integer countyId;
    @XStreamAlias("state-id")
    private Integer stateId;

    public Integer getZipcodeId() {
        return zipcodeId;
    }

    public void setZipcodeId(Integer zipcodeId) {
        this.zipcodeId = zipcodeId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
}
