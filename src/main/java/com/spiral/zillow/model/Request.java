package com.spiral.zillow.model;

public class Request extends ModelClass {
    private String address;
    private String state;
    private String county;
    private String city;
    private String citystatezip;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitystatezip() {
        return citystatezip;
    }

    public void setCitystatezip(String citystatezip) {
        this.citystatezip = citystatezip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
