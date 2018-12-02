package com.spiral.zillow;

import com.spiral.zillow.model.*;
import com.spiral.zillow.model.RealEstate;
import com.spiral.zillow.model.Zestimate;
import com.spiral.zillow.model.chart.Chart;
import com.spiral.zillow.model.chart.RegionChart;
import com.spiral.zillow.model.region.Region;
import com.spiral.zillow.model.region.RegionChildren;
import com.spiral.zillow.model.region.RegionList;
import com.spiral.zillow.model.search.Result;
import com.spiral.zillow.model.search.SearchResults;
import com.spiral.zillow.model.zestimate.ZestimateResults;
import com.thoughtworks.xstream.XStream;

public class XStreamConverter {
    private static XStream XSTREAM = null;

    private XStream getXStream() {
        if (null == XSTREAM) {
            XSTREAM = new XStream();

            // Roots
//            XSTREAM.alias("Chart", Chart.class);
//            XSTREAM.alias("RegionChart:regionchart", RegionChart.class);
//            XSTREAM.alias("RegionChildren:regionchildren", RegionChildren.class);
//            XSTREAM.alias("SearchResults:searchresults", SearchResults.class);
//            XSTREAM.alias("Zestimate:zestimate", ZestimateResults.class);

            // Children
            XSTREAM.alias("address", Address.class);
            XSTREAM.alias("realestate", RealEstate.class);
            XSTREAM.alias("realestateLinks", RealEstateLinks.class);
            XSTREAM.alias("region", Region.class);
            XSTREAM.alias("list", RegionList.class);
            XSTREAM.alias("links", ResultLinks.class);
            XSTREAM.alias("result", Result.class);
            XSTREAM.alias("response", Response.class);
            XSTREAM.alias("valuationRange", ValuationRange.class);
            XSTREAM.alias("zestimate", Zestimate.class);
            XSTREAM.alias("request", Request.class);
            XSTREAM.alias("message", Message.class);

            XSTREAM.aliasAttribute("unit-type", "unitType");

            // Annotations
            XSTREAM.autodetectAnnotations(true);

            // Implicit Collections
            XSTREAM.addImplicitCollection(RegionList.class, "regions");

            // Security
            XSTREAM.allowTypesByWildcard(new String[] {
                    "com.spiral.zillow.**"
            });

            // We may need to ignore some elements in the XML
            XSTREAM.ignoreUnknownElements();
        }

        return XSTREAM;
    }

    public Object fromXML(String xml) {
        Object deserialized = null;

        try {
            deserialized = getXStream().fromXML(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deserialized;
    }

    public String toXML(Object entity) {
        return getXStream().toXML(entity);
    }

}
