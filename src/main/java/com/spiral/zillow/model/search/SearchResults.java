package com.spiral.zillow.model.search;

import com.spiral.zillow.model.Response;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SearchResults")
public class SearchResults extends Response {

    private SearchResponse response;

    public SearchResponse getResponse() {
        return response;
    }

    public void setResponse(SearchResponse response) {
        this.response = response;
    }

}
