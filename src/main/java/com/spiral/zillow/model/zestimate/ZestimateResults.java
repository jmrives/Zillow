package com.spiral.zillow.model.zestimate;

import com.spiral.zillow.model.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Zestimate")
public class ZestimateResults extends Response {

    private ZestimateResponse response;

    public ZestimateResponse getResponse() {
        return response;
    }

    public void setResponse(ZestimateResponse response) {
        this.response = response;
    }
}
