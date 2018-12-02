package com.spiral.zillow.model.chart;

import com.spiral.zillow.model.ModelClass;
import com.spiral.zillow.model.chart.ChartLinks;

public class ChartResponse extends ModelClass {
    private String url;
    private String graphsanddata;
    private ChartLinks links;
    private String zindex;

    public ChartResponse() { }

    public ChartResponse(String url, String graphsanddata, String zindex) {
        this.url = url;
        this.graphsanddata = graphsanddata;
        this.zindex = zindex;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChartLinks getLinks() {
        return links;
    }

    public void setLinks(ChartLinks links) {
        this.links = links;
    }

    public String getZindex() {
        return zindex;
    }

    public void setZindex(String zindex) {
        this.zindex = zindex;
    }

    public String getGraphsanddata() {
        return graphsanddata;
    }

    public void setGraphsanddata(String graphsanddata) {
        this.graphsanddata = graphsanddata;
    }
}
