package com.spiral.zillow.model.region;

import com.spiral.zillow.model.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("RegionChildren")
public class RegionChildren extends Response {
    private RegionResponse response;

    public RegionResponse getResponse() {
        return response;
    }

    public void setResponse(RegionResponse response) {
        this.response = response;
    }

}
