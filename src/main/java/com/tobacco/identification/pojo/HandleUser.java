package com.tobacco.identification.pojo;

import java.io.Serializable;

public class HandleUser implements Serializable {

    private static final long serialVersionUID = -4491416653110989385L;

    private String index;
    private String handle;

    public HandleUser() {
    }

    public String getIndex() {
        return this.index;
    }

    public HandleUser setIndex(String index) {
        this.index = index;
        return this;
    }

    public String getHandle() {
        return this.handle;
    }

    public HandleUser setHandle(String handle) {
        this.handle = handle;
        return this;
    }
}