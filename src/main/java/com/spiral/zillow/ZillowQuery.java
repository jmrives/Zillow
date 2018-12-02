package com.spiral.zillow;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ZillowQuery {
    private static final Logger logger = LoggerFactory.getLogger(ZillowQuery.class);

    private ZillowProperties properties = new ZillowProperties();
    private String queryName;
    private Map<String, String> parameters;
    private XmlFormatter formatter = new DefaultXmlFormatter();

    public ZillowQuery(String queryName, Map<String, String> parameters) {
        this.queryName = queryName;
        this.parameters = parameters;
    }

    public ZillowQuery(String queryName) {
        this.queryName = queryName;
    }

    public ZillowQuery addParameter(String key, String value) {
        if (null == parameters) {
            parameters = new HashMap<String, String>();
        }

        parameters.put(key, value);
        return this;
    }

    public String getQueryName() { return queryName; }

    public String getResponse() {
        return sendAPICall();
    }

    public String getFormattedResponse() {
        return formatter.format(sendAPICall());
    }

    public String getResponse(Map<String, String> parameters) {
        this.parameters = parameters;
        return sendAPICall();
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    private HttpURLConnection createConnection(String parameters) {
        String urlString = properties.getApiBaseUrl() + queryName + ".htm" + parameters;
        String cleaned = urlString.replace(' ', '+'); // Remove spaces from URL

        logger.info("\nCreating connection to " + cleaned);

        HttpURLConnection connection = null;

        try {
            URL url = new URL(cleaned);
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    private String sendAPICall() {
        HttpURLConnection connection = createConnection(toParametersString());
        String output = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            output = toAPIResult(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // We could validate against XSD here.

        String trimmed = trimXML(output);
        return trimmed;
    }

    private String toAPIResult(BufferedReader reader) {
        StringBuffer buffer = new StringBuffer();

        String line = null;
        do {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            buffer.append(line + " \n");
        } while (StringUtils.isNotEmpty(line));

        return buffer.toString();
    }

    private String toParametersString() {
        StringBuffer buffer = new StringBuffer("?zws-id=" + properties.getZwsId());

        if (null == parameters || parameters.isEmpty()) {
            return buffer.toString(); // Just the zwsid
        }

        Set<String> keys = parameters.keySet();

        for (String key: keys) {
            String value = parameters.get(key);

            if (StringUtils.isNotEmpty(value)) {
                buffer.append("&" + key + "=" + value);
            }
        }

        return buffer.toString();
    }

    private String trimXML(String xmlString) {
        // Remove leading <xml> tag
        int startIndex = StringUtils.lastIndexOf(xmlString, "?>") + 2;
        String trimmed = StringUtils.substring(xmlString, startIndex);

        // Trim trailing characters
        int endIndex = StringUtils.lastIndexOf(xmlString, '>') + 1;
        trimmed = StringUtils.substring(trimmed, 0, endIndex);

        // Simplify root tag name
        endIndex = StringUtils.indexOf(trimmed, ':');
        String simpleName = StringUtils.substring(trimmed, 1, endIndex);

        // Remove root tag junk
        startIndex = StringUtils.indexOf(trimmed, '>') + 1;
        trimmed = StringUtils.substring(trimmed, startIndex);

        endIndex = StringUtils.lastIndexOf(trimmed, "</");
        trimmed = StringUtils.substring(trimmed, 0, endIndex);

        String result = "<" + simpleName + ">" + trimmed + "</" + simpleName + ">";

        return result;
    }

}
