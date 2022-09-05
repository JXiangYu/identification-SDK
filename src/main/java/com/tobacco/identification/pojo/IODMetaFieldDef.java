package com.tobacco.identification.pojo;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class IODMetaFieldDef implements Serializable {
    private static final long serialVersionUID = -2780617052261245763L;
    private String name;
    private Integer length;
    private String description;
    private String type;
    private String format;
    private Integer refcol;
    private String refHandle;
    private Integer level;
    private String remark;
    private boolean adminRead;
    private boolean adminWrite;
    private boolean publicRead;
    private boolean publicWrite;

    public IODMetaFieldDef() {
    }

    public String getName() {
        return this.name;
    }

    public IODMetaFieldDef setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLength() {
        return this.length;
    }

    public IODMetaFieldDef setLength(Integer length) {
        this.length = length;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public IODMetaFieldDef setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public IODMetaFieldDef setType(String type) {
        this.type = type;
        return this;
    }

    public String getFormat() {
        return this.format;
    }

    public IODMetaFieldDef setFormat(String format) {
        this.format = format;
        return this;
    }

    public Integer getRefcol() {
        return this.refcol;
    }

    public IODMetaFieldDef setRefcol(Integer refcol) {
        this.refcol = refcol;
        return this;
    }

    public String getRefHandle() {
        return this.refHandle;
    }

    public IODMetaFieldDef setRefHandle(String refHandle) {
        this.refHandle = refHandle;
        return this;
    }

    public String getRemark() {
        return this.remark;
    }

    public IODMetaFieldDef setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getLevel() {
        return this.level;
    }

    public IODMetaFieldDef setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public boolean validity() {
        return null != this && StringUtils.isNotEmpty(this.type) && StringUtils.isNotEmpty(this.name) && null != this.level && this.level > 0;
    }

    public boolean isAdminRead() {
        return this.adminRead;
    }

    public IODMetaFieldDef setAdminRead(boolean adminRead) {
        this.adminRead = adminRead;
        return this;
    }

    public boolean isAdminWrite() {
        return this.adminWrite;
    }

    public IODMetaFieldDef setAdminWrite(boolean adminWrite) {
        this.adminWrite = adminWrite;
        return this;
    }

    public boolean isPublicRead() {
        return this.publicRead;
    }

    public IODMetaFieldDef setPublicRead(boolean publicRead) {
        this.publicRead = publicRead;
        return this;
    }

    public boolean isPublicWrite() {
        return this.publicWrite;
    }

    public IODMetaFieldDef setPublicWrite(boolean publicWrite) {
        this.publicWrite = publicWrite;
        return this;
    }
}