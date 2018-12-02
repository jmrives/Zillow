package com.spiral.zillow;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeException extends IllegalStateException {
    public static final int REGION_CHILDREN = 0;
    public static final int SEARCH_RESULTS = 1;
    public static final int ZESTIMATE_RESULTS = 2;

    private static final Map<String, Integer> apiNameToCallMap = new HashMap<String, Integer>();
    private static final Map<Integer, String> codeMap = new HashMap<Integer, String>();
    private static final Map<Integer, String> regionChildrenCodeMap = new HashMap<Integer, String>();
    private static final Map<Integer, String> searchResultsCodeMap = new HashMap<Integer, String>();
    private static final Map<Integer, String> zestimateResultsCodeMap = new HashMap<Integer, String>();

    static {
        apiNameToCallMap.put("RegionChildren", 0);
        apiNameToCallMap.put("SearchResults", 1);
        apiNameToCallMap.put("ZestimateResults", 2);

        codeMap.put(1, "Service error - there was a server-side error while processing the request");
        codeMap.put(2, "The specified ZWSID parameter was invalid or not specified in the request");
        codeMap.put(3, "Web services are currently unavailable");
        codeMap.put(4, "The API call is currently unavailable");

        regionChildrenCodeMap.put(500, "Invalid regionId parameter");
        regionChildrenCodeMap.put(501, "Invalid parameters");
        regionChildrenCodeMap.put(502, "Region not found");
        regionChildrenCodeMap.put(503, "Invalid childtype parameter");
        regionChildrenCodeMap.put(504, "Invalid childtype for provided parameters");

        searchResultsCodeMap.put(500, "Invalid or missing address parameter");
        searchResultsCodeMap.put(501, "There is no record in our database that corresponds to the specified zpid parameter");
        searchResultsCodeMap.put(502, "No results found");
        searchResultsCodeMap.put(503, "Failed to resolve city, state or ZIP code");
        searchResultsCodeMap.put(504, "No coverage for specified area");
        searchResultsCodeMap.put(505, "Timeout");
        searchResultsCodeMap.put(506, "Address string too long");
        searchResultsCodeMap.put(507, "No exact match found");

        zestimateResultsCodeMap.put(500, "The specified zpid parameter was not specified or invalid");
        zestimateResultsCodeMap.put(501, "Invalid or missing citystatezip parameter");
        zestimateResultsCodeMap.put(502, "The property identified by the specified zpid does not have a Zestimate");

    }

    private int apiCall;
    private int code;

    public ErrorCodeException(int apiCall, int code) {
        this.apiCall = apiCall;
        this.code = code;
    }

    public ErrorCodeException(String apiName, int code) {
        this.apiCall = nameToApiCall(apiName);
        this.code = code;
    }

    private int nameToApiCall(String name) {
        Integer value = apiNameToCallMap.get(name);
        return null == value ? -1 : value;
    }

    public int getApiCall() {
        return apiCall;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return getErrorMessage();
    }

    private String getErrorMessage() {
        if (code < 5) {
            return codeMap.get(code);
        }

        String errorMessage = null;

        switch (apiCall) {
            case REGION_CHILDREN:
                errorMessage = regionChildrenCodeMap.get(code);
                break;
            case SEARCH_RESULTS:
                errorMessage = searchResultsCodeMap.get(code);
                break;
            case ZESTIMATE_RESULTS:
                errorMessage = zestimateResultsCodeMap.get(code);
                break;
            default:
                errorMessage = "Unknown API call.";
                break;
        }

        if (null == errorMessage) {
            errorMessage = "Unknown error";
        }

        return "Error Code " + code + ": " + errorMessage;
    }

}
