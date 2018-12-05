package com.spiral.zillow.model.chart;

import com.spiral.zillow.model.ModelClass;
import com.spiral.zillow.model.Response;
import com.spiral.zillow.model.ZIndex;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ChartResponse extends Response {
    private String url;

    @XStreamAlias("graphsanddata")
    private String graphsanddata;

    private ChartLinks links;
    private ZIndex zindex;

    public ChartResponse() { }

    public ChartResponse(String url, String graphsAndData, ZIndex zindex) {
        this.url = url;
        this.graphsanddata = graphsAndData;
        this.zindex = zindex;
    }

}
