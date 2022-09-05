package com.tobacco.identification.vo;

public class ResultInfo {
    private String code;
    private String msg;
    private Object obj;
    private boolean isOK;

    public ResultInfo() {
    }

    public String getCode() {
        return this.code;
    }

    public ResultInfo setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public ResultInfo setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return this.obj;
    }

    public ResultInfo setObj(Object obj) {
        this.obj = obj;
        return this;
    }

    public boolean isOK() {
        return this.isOK;
    }

    public ResultInfo setOK(boolean OK) {
        this.isOK = OK;
        return this;
    }

    public String toString() {
        return "ResultInfo{code='" + this.code + '\'' + ", msg='" + this.msg + '\'' + ", obj=" + this.obj + ", isOK=" + this.isOK + '}';
    }
}