package com.spiral.zillow;

import com.spiral.zillow.exceptions.ErrorCodeException;
import com.spiral.zillow.model.ZIndex;
import com.spiral.zillow.model.chart.ChartResponse;
import com.spiral.zillow.model.region.Region;
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

        ChartResponse response = client.getChart(PROPERTY_ID, UNIT_TYPE, 300, 200, "1year");
        assertNotNull("The response should not be null", response);

        end("getChart");
    }

    

    @Test
    public void testGetRegionChart() throws Exception {
        start("getRegionChart");

        ChartResponse response = client.getRegionChart(PROPERTY_ID, UNIT_TYPE, 300, 200, "1year");
        assertNotNull("The response should not be null", response);

        end("getRegionChart");
    }

    @Test
    public void testGetDeepSearchResults() throws Exception {
        start("getDeepSearchResults");

        SearchResponse response = client.getDeepSearchResults(ADDRESS, ZIPCODE, RENT_ZESTIMATE);
        assertNotNull("The response should not be null", response);
        assertNotNull("The list of response results should not be null", response.getResults());
        assertEquals("We should get only one result.", response.getResults().size(), 1);
        logger.info("Got " + response.getResults().size() + " result");

        end("getDeepSearchResults");
    }

    @Test
    public void testGetRegionChildren() throws Exception {
        start("getRegionChildren");

        // The regionId is not working
        RegionResponse response = client.getRegionChildren(null, STATE, COUNTY, CITY, CHILD_TYPE);
        assertNotNull("The response should not be null", response);
        assertNotNull("The response region list should not be null", response.getList());
        assertTrue("We should get at least one region.", response.getList().getCount() > 0);
        assertNotNull("The list of response list regions should not be null", response.getList().getRegions());
        logger.info("Got " + response.getList().getCount() + " result(s)");

        end("getRegionChildren");
    }

    @Test
    public void testGetSearchResults() throws Exception {
        start("getSearchResults");

        SearchResponse response =  client.getSearchResults(ADDRESS, ZIPCODE, RENT_ZESTIMATE);
        assertNotNull("The response should not be null", response);
        assertNotNull("The list of response results should not be null", response.getResults());
        assertEquals("We should get only one result.", response.getResults().size(), 1);
        logger.info("Got " + response.getResults().size() + " result");

        end("getSearchResults");
    }

    @Test
    public void testGetZestimate() throws Exception {
        start("getZestimate");

        ZestimateResponse response = client.getZestimate(PROPERTY_ID, RENT_ZESTIMATE);
        assertNotNull("The response should not be null", response);

        end("getZestimate");
    }


}
