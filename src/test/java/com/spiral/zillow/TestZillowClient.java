package com.spiral.zillow;

import com.spiral.zillow.model.chart.ChartResponse;
import com.spiral.zillow.model.region.RegionResponse;
import com.spiral.zillow.model.search.SearchResponse;
import com.spiral.zillow.model.zestimate.ZestimateResponse;
import com.spiral.zillow.util.ANSICode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class TestZillowClient extends BaseShivaTest {
    private static final Logger logger = LoggerFactory.getLogger(TestZillowClient.class);

    private ZillowClient client = new ZillowClient();

    public TestZillowClient() {
        super("ZillowClient");
    }

    @Test
    public void testGetChart() throws Exception {
        start("getChart");

        try {
            ChartResponse response = client.getChart(PROPERTY_ID, UNIT_TYPE, 300, 200, "1year");
            assertNotNull("The response should not be null", response);
        } catch (ErrorCodeException e) {
            logger.error(e.getMessage());
        }

        end("getChart");
    }

    

    @Test
    public void testGetRegionChart() throws Exception {
        start("getRegionChart");

        try {
            ChartResponse response = client.getRegionChart(PROPERTY_ID, UNIT_TYPE, 300, 200, "1year");
            assertNotNull("The response should not be null", response);
        } catch (ErrorCodeException e) {
            logger.error(e.getMessage());
        }

        end("getRegionChart");
    }

    @Test
    public void testGetDeepSearchResults() throws Exception {
        start("getDeepSearchResults");

        try {
            SearchResponse response = client.getDeepSearchResults(ADDRESS, ZIPCODE, RENT_ZESTIMATE);
            assertNotNull("The response should not be null", response);
            assertNotNull("The list of response results should not be null", response.getResults());
            assertEquals("We should get only one result.", response.getResults().size(), 1);
            logger.info("Got " + response.getResults().size() + " result");
        } catch (ErrorCodeException e) {
            logger.error(e.getMessage());
        }

        end("getDeepSearchResults");
    }

    @Test
    public void testGetRegionChildren() throws Exception {
        start("getRegionChildren");

        try {
            RegionResponse response = client.getRegionChildren(REGION_ID, STATE, COUNTY, CITY, CHILD_TYPE);
            assertNotNull("The response should not be null", response);
            assertNotNull("The response region list should not be null", response.getList());
            assertTrue("We should get at least one region.", response.getList().getCount() > 0);
            assertNotNull("The list of response list regions should not be null", response.getList().getRegions());
            logger.info("Got " + response.getList().getCount() + " result(s)");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        end("getRegionChildren");
    }

    @Test
    public void testGetSearchResults() throws Exception {
        start("getSearchResults");

        try {
            SearchResponse response =  client.getSearchResults(ADDRESS, ZIPCODE, RENT_ZESTIMATE);
            assertNotNull("The response should not be null", response);
            assertNotNull("The list of response results should not be null", response.getResults());
            assertEquals("We should get only one result.", response.getResults().size(), 1);
            logger.info("Got " + response.getResults().size() + " result");
        } catch (ErrorCodeException e) {
            logger.error(e.getMessage());
        }

        end("getSearchResults");
    }

    @Test
    public void testGetZestimate() throws Exception {
        start("getZestimate");

        try {
            ZestimateResponse response = client.getZestimate(PROPERTY_ID, RENT_ZESTIMATE);
            assertNotNull("The response should not be null", response);
        } catch (ErrorCodeException e) {
            String message = "\n" + decorator.start(ANSICode.BackgroundBlack.RedText) + e.getMessage();
            logger.error(message);
        }

        end("getZestimate");
    }


}
