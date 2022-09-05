package com.tobacco.identification.pojo;

import java.io.Serializable;

public class IODMetaShow implements Serializable {
    private static final long serialVersionUID = -4578404377043854058L;
    private String name;
    private String appScene;
    private String symbol;
    private String symbolSize;
    private IODMetaShowItem itemStyle;

    public IODMetaShow() {
    }

    public String getName() {
        return this.name;
    }

    public IODMetaShow setName(String name) {
        this.name = name;
        return this;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public IODMetaShow setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getSymbolSize() {
        return this.symbolSize;
    }

    public IODMetaShow setSymbolSize(String symbolSize) {
        this.symbolSize = symbolSize;
        return this;
    }

    public IODMetaShowItem getItemStyle() {
        return this.itemStyle;
    }

    public IODMetaShow setItemStyle(IODMetaShowItem itemStyle) {
        this.itemStyle = itemStyle;
        return this;
    }

    public String getAppScene() {
        return this.appScene;
    }

    public IODMetaShow setAppScene(String appScene) {
        this.appScene = appScene;
        return this;
    }
}