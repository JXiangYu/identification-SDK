package com.tobacco.identification.pojo;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class IODMetaData implements Serializable {
    private static final long serialVersionUID = 7793502516695454406L;
    private Long id;
    private String tableName;
    private String description;
    private String rule;
    private List<IODMetaFieldDef> colDefList;
    private String parentTableName;
    private String outerJoin;
    private String categoryHandle;
    private String version;
    private String status;
    private IODMetaShow iodMetaShow;
    private String remark;
    private String referenceHandle;
    private Integer businessApprove;
    private String dataTemplate;
    private String isReferenced;
    private String manager;

    public IODMetaData() {
    }

    public Long getId() {
        return this.id;
    }

    public IODMetaData setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTableName() {
        return this.tableName;
    }

    public IODMetaData setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public IODMetaData setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<IODMetaFieldDef> getColDefList() {
        return this.colDefList;
    }

    public IODMetaData setColDefList(List<IODMetaFieldDef> colDefList) {
        this.colDefList = colDefList;
        return this;
    }

    public String getParentTableName() {
        return this.parentTableName;
    }

    public IODMetaData setParentTableName(String parentTableName) {
        this.parentTableName = parentTableName;
        return this;
    }

    public String getCategoryHandle() {
        return this.categoryHandle;
    }

    public IODMetaData setCategoryHandle(String categoryHandle) {
        this.categoryHandle = categoryHandle;
        return this;
    }

    public String getVersion() {
        return this.version;
    }

    public IODMetaData setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public IODMetaData setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return this.remark;
    }

    public IODMetaData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getOuterJoin() {
        return this.outerJoin;
    }

    public IODMetaData setOuterJoin(String outerJoin) {
        this.outerJoin = outerJoin;
        return this;
    }

    public IODMetaFieldDef findMetaFieldDef(String fieldName) {
        if (!StringUtils.isEmpty(fieldName) && null != this.colDefList && !this.colDefList.isEmpty()) {
            Iterator var2 = this.colDefList.iterator();

            IODMetaFieldDef iodMetaFieldDef;
            do {
                if (!var2.hasNext()) {
                    return null;
                }

                iodMetaFieldDef = (IODMetaFieldDef)var2.next();
            } while(!iodMetaFieldDef.getName().equals(fieldName));

            return iodMetaFieldDef;
        } else {
            return null;
        }
    }

    public IODMetaShow getIodMetaShow() {
        return this.iodMetaShow;
    }

    public IODMetaData setIodMetaShow(IODMetaShow iodMetaShow) {
        this.iodMetaShow = iodMetaShow;
        return this;
    }

    public String getRule() {
        return this.rule;
    }

    public IODMetaData setRule(String rule) {
        this.rule = rule;
        return this;
    }

    public String getReferenceHandle() {
        return this.referenceHandle;
    }

    public IODMetaData setReferenceHandle(String referenceHandle) {
        this.referenceHandle = referenceHandle;
        return this;
    }

    public Integer getBusinessApprove() {
        return this.businessApprove;
    }

    public IODMetaData setBusinessApprove(Integer businessApprove) {
        this.businessApprove = businessApprove;
        return this;
    }

    public String getDataTemplate() {
        return this.dataTemplate;
    }

    public IODMetaData setDataTemplate(String dataTemplate) {
        this.dataTemplate = dataTemplate;
        return this;
    }

    public String getIsReferenced() {
        return this.isReferenced;
    }

    public IODMetaData setIsReferenced(String isReferenced) {
        this.isReferenced = isReferenced;
        return this;
    }

    public String getManager() {
        return this.manager;
    }

    public IODMetaData setManager(String manager) {
        this.manager = manager;
        return this;
    }
}