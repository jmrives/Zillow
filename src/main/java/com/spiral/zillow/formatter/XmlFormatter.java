package com.spiral.zillow.formatter;

public abstract class XmlFormatter {
    private int indentation;

    public XmlFormatter(int indentation) {
        this.indentation = indentation;
    }

    public abstract String format(String xml);

    public String format(String xml, int indentation) {
        setIndentation(indentation);
        return format(xml);
    }

    protected int getIndentation() { return indentation; }

    protected void setIndentation(int indentation) { this.indentation = indentation; }

}
