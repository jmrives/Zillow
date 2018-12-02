package com.spiral.zillow;

public class LimitWarningException extends IllegalStateException {
    private static final String WARNING_MESSAGE = "The response from Zillow includes a limit warning.";

    public LimitWarningException() {
        super(WARNING_MESSAGE);
    }

    public LimitWarningException(String message) {
        super(message);
    }

}
