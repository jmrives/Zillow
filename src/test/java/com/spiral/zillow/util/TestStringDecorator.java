package com.spiral.zillow.util;

import org.junit.Test;

public class TestStringDecorator {

    private StringDecorator decorator = new StringDecorator();

    @Test
    public void testTextColors() throws Exception {
        System.out.println("\nText Colors: ");
        System.out.println(decorator.decorateText(ANSICode.RedText, "Red Text"));
        System.out.println(decorator.decorateText(ANSICode.GreenText, "Green Text"));
        System.out.println(decorator.decorateText(ANSICode.YellowText, "Yellow Text"));
        System.out.println(decorator.decorateText(ANSICode.BlueText, "Blue Text"));
        System.out.println(decorator.decorateText(ANSICode.MagentaText, "Magenta Text"));
        System.out.println(decorator.decorateText(ANSICode.CyanText, "Cyan Text"));
    }

    @Test
    public void testFormatOptions() throws Exception {
        System.out.println("\nFormat Options: ");
        System.out.println(decorator.decorateText(ANSICode.BoldOn, "Bold"));
        System.out.println(decorator.decorateText(ANSICode.ItalicsOn, "Italics"));
        System.out.println(decorator.decorateText(ANSICode.UnderlineOn, "Underline"));
        System.out.println(decorator.decorateText(ANSICode.InverseOn, "Inverse"));
        System.out.println(decorator.decorateText(ANSICode.StrikethroughOn, "Strikethrough"));
    }

    @Test
    public void testForegroundColors() throws Exception {
        System.out.println("\nForeground Colors: ");
        System.out.println(decorator.decorateText(ANSICode.ForegroundBlack, "Black Foreground"));
        System.out.println(decorator.decorateText(ANSICode.ForegroundRed, "Red Foreground"));
        System.out.println(decorator.decorateText(ANSICode.ForegroundGreen, "Green Foreground"));
        System.out.println(decorator.decorateText(ANSICode.ForegroundYellow, "Yellow Foreground"));
        System.out.println(decorator.decorateText(ANSICode.ForegroundBlue, "Blue Foreground"));
        System.out.println(decorator.decorateText(ANSICode.ForegroundMagenta, "Magenta Foreground"));
        System.out.println(decorator.decorateText(ANSICode.ForegroundCyan, "Cyan Foreground"));
        System.out.println(decorator.decorateText(ANSICode.ForegroundWhite, "White Foreground"));
        System.out.println(decorator.decorateText(ANSICode.ForegroundDefault, "Default Foreground"));
    }

    @Test
    public void testBackgroundColors() throws Exception {
        System.out.println("\nBackground Colors: ");
        System.out.println(decorator.decorateText(ANSICode.BackgroundBlack, "Black Background"));
        System.out.println(decorator.decorateText(ANSICode.BackgroundRed, "Red Background"));
        System.out.println(decorator.decorateText(ANSICode.BackgroundGreen, "Green Background"));
        System.out.println(decorator.decorateText(ANSICode.BackgroundYellow, "Yellow Background"));
        System.out.println(decorator.decorateText(ANSICode.BackgroundBlue, "Blue Background"));
        System.out.println(decorator.decorateText(ANSICode.BackgroundMagenta, "Magenta Background"));
        System.out.println(decorator.decorateText(ANSICode.BackgroundCyan, "Cyan Background"));
        System.out.println(decorator.decorateText(ANSICode.BackgroundWhite, "White Background"));
        System.out.println(decorator.decorateText(ANSICode.BackgroundDefault, "Default Background"));
    }

}
