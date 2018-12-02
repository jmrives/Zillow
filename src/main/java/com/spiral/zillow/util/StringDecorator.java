package com.spiral.zillow.util;

public class StringDecorator {

    // Control codes
    private static final String ESCAPE = "\033";
    private static final String RESET = "[0m";

    public String decorateText(ANSICode code, String original) {
        return ESCAPE + code.getValue() + original + ESCAPE + RESET;
    }

    public String reset() { return ESCAPE + RESET; }

    public String start(ANSICode code) {
        return ESCAPE + code.getValue();
    }

}


