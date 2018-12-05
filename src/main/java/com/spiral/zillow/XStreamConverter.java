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

    private static XStream getXStream() {
        if (null == XSTREAM) {
            XSTREAM = new XStream();

            // Annotations
            XSTREAM.autodetectAnnotations(true);

            // Security
            XSTREAM.allowTypesByWildcard(new String[] {
                    "com.spiral.zillow.**"
            });

            // We may need to ignore some elements in the XML
            XSTREAM.ignoreUnknownElements();
        }

        return XSTREAM;
    }

    public static Object fromXML(String xml) {
        Object deserialized = null;

        try {
            deserialized = getXStream().fromXML(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deserialized;
    }

    public static String toXML(Object entity) {
        return getXStream().toXML(entity);
    }

}
