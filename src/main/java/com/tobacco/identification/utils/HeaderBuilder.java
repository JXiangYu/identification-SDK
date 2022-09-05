package com.tobacco.identification.utils;

import java.util.HashMap;
import java.util.Map;

public class HeaderBuilder {
    public HeaderBuilder() {
    }

    public static final Map<String, String> buildJsonHeader() {
        Map<String, String> headers = new HashMap();
        headers.put("ContentType", "application/json");
        return headers;
    }

    public static final synchronized Map<String, String> putParam(Map<String, String> header, String key, String value) {
        header.put(key, value);
        return header;
    }
}