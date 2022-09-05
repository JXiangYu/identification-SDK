package com.tobacco.identification.vo;

public class ResultHelper {

    public ResultHelper() {
    }

    public static ResultInfo getSuccess(HttpCodeDef codeDef, Object obj) {
        return (new ResultInfo()).setCode(codeDef.getCode() + "").setMsg(codeDef.getMsg()).setOK(true).setObj(obj);
    }

    public static ResultInfo getSuccess(Object obj) {
        return (new ResultInfo()).setCode(HttpCodeDef.Success.getCode() + "").setMsg(HttpCodeDef.Success.getMsg()).setOK(true).setObj(obj);
    }

    public static final ResultInfo requestException(HttpCodeDef httpCodeDef, Object object) {
        return (new ResultInfo()).setCode(httpCodeDef.getCode() + "").setMsg(httpCodeDef.getMsg()).setObj(object).setOK(false);
    }

    public static ResultInfo requestFaild(HttpCodeDef httpCodeDef) {
        return (new ResultInfo()).setCode(httpCodeDef.getCode() + "").setMsg(httpCodeDef.getMsg()).setOK(false).setObj((Object)null);
    }

    public static ResultInfo requestFaild(String message, String code) {
        return (new ResultInfo()).setCode(code).setMsg(message).setOK(false).setObj((Object)null);
    }

    public static ResultInfo requestFaild(String message) {
        return (new ResultInfo()).setCode(HttpCodeDef.InterError.getCode() + "").setMsg(message).setOK(false).setObj((Object)null);
    }
}