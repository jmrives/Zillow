package com.spiral.zillow;

import com.spiral.zillow.util.ANSICode;
import com.spiral.zillow.util.StringDecorator;
import com.spiral.zillow.util.ANSICode;
import com.spiral.zillow.util.StringDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseShivaTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseShivaTest.class);

    protected static String ADDRESS = "425 Clifton Road NE";
    protected static String CITY_STATE = "Atlanta Georgia";
    protected static String CITY_STATE_ZIP = "Atlanta Georgia 30307";
    protected static String ZIPCODE = "30307";
    protected static Boolean RENT_ZESTIMATE = true;
    protected static Integer REGION_ID = 37211;
    protected static String STATE = "Georgia";
    protected static String COUNTY = "Dekalb";
    protected static String CITY = "Atlanta";
    protected static String CHILD_TYPE = "";
    protected static Integer PROPERTY_ID = 48749425;
    protected static String UNIT_TYPE = "dollar";

    private String classUnderTest;
    protected StringDecorator decorator = new StringDecorator();

    protected BaseShivaTest(String classUnderTest) {
        this.classUnderTest = classUnderTest;
    }

    protected void end(String testName) {
        System.out.print(decorator.start(ANSICode.GreenText));
        System.out.println("\n*******");
        System.out.println("Ending test " + classUnderTest + "." + testName);
        System.out.println("*******\n");
        System.out.print(decorator.reset());
    }

    protected void start(String testName) {
        System.out.print(decorator.start(ANSICode.GreenText));
        System.out.println("\n*******");
        System.out.println("Starting test " + classUnderTest + "." + testName);
        System.out.println("*******\n");
        System.out.print(decorator.reset());
    }

}
