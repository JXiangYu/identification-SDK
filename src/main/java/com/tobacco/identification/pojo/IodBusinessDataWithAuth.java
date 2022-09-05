package com.tobacco.identification.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName IodBusinessDataWithAuth
 * @Description 业务数据列Model
 * @Author JXiangYu
 * @Date 2020/7/15 16:28
 * @Version 1.0
 */
public class IodBusinessDataWithAuth implements Serializable {

    /**
     * index
     */
    private Integer index;

    /**
     * 字段名
     */
    private String field;
    /**
     * 字段类型
     */
    private String type;
    /**
     * 字段最大长度
     */
    private Integer length;
    /**
     * 描述
     */
    private String description;

    /**
     * 数据
     */
    private String data;

    /**
     * 保密等级
     */
    private Integer level;

    /**
     * 管理员读权限
     */
    private boolean adminRead;

    /**
     * 管理员写权限
     */
    private boolean adminWrite;

    /**
     * 匿名读权限
     */
    private boolean publicRead;

    /**
     * 匿名写权限
     */
    private boolean publicWrite;

    /**
     * 扩展权限
     */
    private List<ExtendsAuth> editorAuth;

    public IodBusinessDataWithAuth() {
        level = 1;
        type = "String";
    }

    public Integer getIndex() {
        return index;
    }

    public IodBusinessDataWithAuth setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public boolean isAdminRead() {
        return adminRead;
    }

    public IodBusinessDataWithAuth setAdminRead(boolean adminRead) {
        this.adminRead = adminRead;
        return this;
    }

    public boolean isAdminWrite() {
        return adminWrite;
    }

    public IodBusinessDataWithAuth setAdminWrite(boolean adminWrite) {
        this.adminWrite = adminWrite;
        return this;
    }

    public boolean isPublicRead() {
        return publicRead;
    }

    public IodBusinessDataWithAuth setPublicRead(boolean publicRead) {
        this.publicRead = publicRead;
        return this;
    }

    public boolean isPublicWrite() {
        return publicWrite;
    }

    public IodBusinessDataWithAuth setPublicWrite(boolean publicWrite) {
        this.publicWrite = publicWrite;
        return this;
    }

    public String getField() {
        return field;
    }

    public IodBusinessDataWithAuth setField(String field) {
        this.field = field;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public IodBusinessDataWithAuth setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getData() {
        return data;
    }

    public IodBusinessDataWithAuth setData(String data) {
        this.data = data;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public IodBusinessDataWithAuth setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public IodBusinessDataWithAuth setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public String getType() {
        return type;
    }

    public IodBusinessDataWithAuth setType(String type) {
        this.type = type;
        return this;
    }
}
