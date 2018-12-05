package com.spiral.zillow.model.region;

import com.spiral.zillow.model.ModelClass;
import com.spiral.zillow.model.ZIndex;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("region")
public class Region extends ModelClass {
    private String id;
    private String name;
    private ZIndex zindex;
    private String latitude;
    private String longitude;

    public Region(String id, String name, ZIndex zindex, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.zindex = zindex;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZIndex getZindex() {
        return zindex;
    }

    public void setZindex(ZIndex zindex) {
        this.zindex = zindex;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
