package com.spiral.zillow.model.chart;

import com.spiral.zillow.model.ModelClass;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ChartRequest extends ModelClass {
    private Integer zpid;
    @XStreamAlias("unit-type")
    private String unitType;
    private Integer width;
    private Integer height;
    private String chartDuration;

    public ChartRequest() { }

    public ChartRequest(Integer zpid, String unitType, Integer width, Integer height, String chartDuration) {
        this.zpid = zpid;
        this.unitType = unitType;
        this.width =width;
        this.height = height;
        this.chartDuration = chartDuration;
    }

    public Integer getZpid() {
        return zpid;
    }

    public void setZpid(Integer zpid) {
        this.zpid = zpid;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getChartDuration() {
        return chartDuration;
    }

    public void setChartDuration(String chartDuration) {
        this.chartDuration = chartDuration;
    }
}
