package com.spiral.zillow.util;

public enum ANSICode {

    // Text Colors
    RedText("[31m"),
    GreenText("[32m"),
    YellowText("[33m"),
    BlueText("[34m"),
    MagentaText("[35m"),
    CyanText("[36m"),

    // Format
    BoldOn("[1m"),
    ItalicsOn("[3m"),
    UnderlineOn("[4m"),
    InverseOn("[7m"),
    StrikethroughOn("[9m"),
    BoldOff("[22m"),
    ItalicsOff("[23m"),
    UnderlineOff("[24m"),
    InverseOff("[27m"),
    StrikethroughOff("[29m"),

    // Foreground Colors
    ForegroundBlack("[30m"),
    ForegroundRed("[31m"),
    ForegroundGreen("[32m"),
    ForegroundYellow("[33m"),
    ForegroundBlue("[34m"),
    ForegroundMagenta("[35m"),
    ForegroundCyan("[36m"),
    ForegroundWhite("[37m"),
    ForegroundDefault("[39m"),   // The default is white

    // Background Colors
    BackgroundBlack("[40m"),
    BackgroundRed("[41m"),
    BackgroundGreen("[42m"),
    BackgroundYellow("[43m"),
    BackgroundBlue("[44m"),
    BackgroundMagenta("[45m"),
    BackgroundCyan("[46m"),
    BackgroundWhite("[47m"),
    BackgroundDefault("[49m");   // The default is black

    private String value;

    private ANSICode(String value) {
        this.value = value;
    }

    public String getValue() { return value; }

}
