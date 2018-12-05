package com.spiral.zillow.model;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class OneWeekChange {

    @XStreamAsAttribute
    private Boolean deprecated;

    public OneWeekChange() { }

    public OneWeekChange(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public Boolean isDepricated() {
        return deprecated;
    }

    public void setDepricated(boolean depricated) {
        this.deprecated = depricated;
    }
}
