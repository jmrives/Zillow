package com.spiral.zillow.model.chart;

import com.spiral.zillow.model.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Chart")
public class Chart extends Response {

    private ChartRequest request;
    private ChartResponse response;

    public ChartRequest getRequest() {
        return request;
    }

    public void setRequest(ChartRequest request) {
        this.request = request;
    }

    public ChartResponse getResponse() {
        return response;
    }

    public void setResponse(ChartResponse response) {
        this.response = response;
    }
}
