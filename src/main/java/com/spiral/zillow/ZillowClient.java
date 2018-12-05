package com.spiral.zillow;

import com.spiral.zillow.exceptions.ErrorCodeException;
import com.spiral.zillow.exceptions.LimitWarningException;
import com.spiral.zillow.model.Message;
import com.spiral.zillow.model.Response;
import com.spiral.zillow.model.chart.*;
import com.spiral.zillow.model.region.RegionChildren;
import com.spiral.zillow.model.region.RegionResponse;
import com.spiral.zillow.model.search.SearchResponse;
import com.spiral.zillow.model.search.SearchResults;
import com.spiral.zillow.model.zestimate.ZestimateResponse;
import com.spiral.zillow.model.zestimate.ZestimateResults;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ZillowClient {
    private static final Logger logger = LoggerFactory.getLogger(ZillowClient.class);

    private static final String FILE_OUTPUT_ROOT = "./target/output/";

    private File rootOutputDirectory = null;

    private static final String GET_CHART = "GetChart";
    private static final String GET_DEEP_SEARCH_RESULTS = "GetDeepSearchResults";
    private static final String GET_REGION_CHART = "GetRegionChart";
    private static final String GET_REGION_CHILDREN = "GetRegionChildren";
    private static final String GET_SEARCH_RESULTS = "GetSearchResults";
    private static final String GET_ZESTIMATE = "GetZestimate";

    public ChartResponse getChart(Integer propertyId, String unitType, Integer width, Integer height, String chartDuration) {
        ZillowQuery query = new ZillowQuery(GET_CHART);
        query.addParameter("zpid", toString(propertyId));
        query.addParameter("unit-type", unitType);
        query.addParameter("width", toString(width));
        query.addParameter("height", toString(height));
        query.addParameter("chartDuration", chartDuration);

        String xmlResponse = query.getFormattedResponse();
        printToFile(query.getQueryName() + ".xml", xmlResponse);
        Chart chart = (Chart) toResponse(xmlResponse, new Chart());
        return chart.getResponse();
    }

    public ChartResponse getRegionChart(Integer propertyId, String unitType, Integer width, Integer height, String chartDuration) {
        ZillowQuery query = new ZillowQuery(GET_REGION_CHART);
        query.addParameter("zpid", toString(propertyId));
        query.addParameter("unit-type", unitType);
        query.addParameter("width", toString(width));
        query.addParameter("height", toString(height));
        query.addParameter("chartDuration", chartDuration);

        String xmlResponse = query.getFormattedResponse();
        printToFile(query.getQueryName() + ".xml", xmlResponse);
        RegionChart chart = (RegionChart) toResponse(xmlResponse, new RegionChart());
        return chart.getResponse();
   }

    public SearchResponse getDeepSearchResults(String address, String cityStateZip, Boolean rentZestimate) {
        ZillowQuery query = new ZillowQuery(GET_DEEP_SEARCH_RESULTS);
        query.addParameter("address", address);
        query.addParameter("citystatezip", cityStateZip);
        query.addParameter("rentzestimate", toString(rentZestimate));

        String xmlResponse = query.getFormattedResponse();
        printToFile(query.getQueryName() + ".xml", xmlResponse);
        SearchResults searchResults = (SearchResults) toResponse(xmlResponse, new SearchResults());
        return searchResults.getResponse();
    }

    public RegionResponse getRegionChildren(Integer regionId, String state, String county, String city, String childType) {
        if (null == regionId && StringUtils.isEmpty(state)) {
            throw new IllegalArgumentException("Either regionId or state must be specified.");
        }

        ZillowQuery query = new ZillowQuery(GET_REGION_CHILDREN);
        query.addParameter("regionId", toString(regionId));
        query.addParameter("state", state);
        query.addParameter("county", county);
        query.addParameter("city", city);
        query.addParameter("childtype", childType);

        String xmlResponse = query.getFormattedResponse();
        printToFile(query.getQueryName() + ".xml", xmlResponse);
        RegionChildren regionChildren = (RegionChildren) toResponse(xmlResponse, new RegionChildren());
        return regionChildren.getResponse();
    }

    public SearchResponse getSearchResults(String address, String cityStateZip, Boolean rentZestimate) {
        ZillowQuery query = new ZillowQuery(GET_SEARCH_RESULTS);
        query.addParameter("address", address);
        query.addParameter("citystatezip", cityStateZip);
        query.addParameter("rentzestimate", toString(rentZestimate));

        String xmlResponse = query.getFormattedResponse();
        printToFile(query.getQueryName() + ".xml", xmlResponse);
        SearchResults searchResults = (SearchResults) toResponse(xmlResponse, new SearchResults());
        return searchResults.getResponse();
    }

    public ZestimateResponse getZestimate(Integer propertyId, Boolean rentZestimate) {
        ZillowQuery query = new ZillowQuery(GET_ZESTIMATE);
        query.addParameter("zpid", toString(propertyId));
        query.addParameter("rentzestimate", toString(rentZestimate));

        String xmlResponse = query.getFormattedResponse();
        printToFile(query.getQueryName() + ".xml", xmlResponse);
        ZestimateResults zestimateResults = (ZestimateResults) toResponse(xmlResponse, new ZestimateResults());
        return zestimateResults.getResponse();
    }

    private void printToFile(String fileName, String xml) {
        if (null == rootOutputDirectory) {
            rootOutputDirectory = new File(FILE_OUTPUT_ROOT);
            if (!rootOutputDirectory.exists()) {
                rootOutputDirectory.mkdirs();
            }
            if (!rootOutputDirectory.isDirectory()) {
                throw new RuntimeException("The root output directory is not a directory");
            }
        }

        File outputFile = new File(rootOutputDirectory, fileName);
        PrintStream printStream = null;

        try {
            printStream = new PrintStream(outputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        printStream.println("\n");
        printStream.print(xml);
        printStream.println("\n");
    }

    private Response toResponse(String xml, Response instance) {
        XStreamConverter.toXML(instance);
        return toResponse(xml);
    }

    private Response toResponse(String xml) {
        Response response = (Response) XStreamConverter.fromXML(xml);
        String responseClassName = response.getClass().getSimpleName();
        validate(responseClassName, response.getMessage());
        response.setServerResponse(xml);
        return response;
    }

    private String toString(Boolean value) {
        if (null == value) {
            return (String) null;
        }

        return value.toString();
    }

    private String toString(Integer value) {
        if (null == value) {
            return (String) null;
        }

        return value.toString();
    }

    private void validate(String apiCallName, Message message) {
        if (null != message.getLimitWarning() && message.getLimitWarning()) {
            throw new LimitWarningException();
        }

        if (message.getCode() > 0) {
            throw new ErrorCodeException(apiCallName, message.getCode(), message.getText());
        }
    }

}
