package com.tobacco.identification.pojo;

import java.io.Serializable;

public class IODMetaShowItem implements Serializable {
    private static final long serialVersionUID = -2789820375225239001L;
    private String color;

    public IODMetaShowItem() {
    }

    public String getColor() {
        return this.color;
    }

    public IODMetaShowItem setColor(String color) {
        this.color = color;
        return this;
    }
}