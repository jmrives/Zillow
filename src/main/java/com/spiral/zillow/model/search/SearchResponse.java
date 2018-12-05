package com.spiral.zillow.model.search;

import com.spiral.zillow.model.Response;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

public class SearchResponse extends Response {

    @XStreamImplicit
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
