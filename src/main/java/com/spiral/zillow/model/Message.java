package com.spiral.zillow.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Message extends ModelClass {
    private String text;
    private Integer code;
    @XStreamAlias("limit-warning")
    private Boolean limitWarning;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getLimitWarning() {
        return limitWarning;
    }

    public void setLimitWarning(Boolean limitWarning) {
        this.limitWarning = limitWarning;
    }
}
