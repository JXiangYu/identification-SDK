package com.tobacco.identification.vo;

public enum HttpCodeDef {
    Message(100, "继续发送请求"),
    Message_101(101, "协议切换"),
    Message_102(102, "继续执行"),
    Success(200, "操作成功"),
    Success_201(201, "请求成功"),
    Success_202(202, "已接受请求"),
    Success_203(203, "已处理请求"),
    Success_204(204, "已处理请求"),
    Success_205(205, "已处理请求"),
    Success_206(206, "已处理部分请求"),
    Success_207(207, "即将传输XML"),
    Redirect(300, "请选择"),
    Redirect_301(301, "已转移"),
    Redirect_302(302, "临时转移"),
    Redirect_303(303, "查找另一个URL"),
    Redirect_304(304, "缓存"),
    Redirect_305(305, "指定代理"),
    Redirect_306(306, "Switch Proxy"),
    Redirect_307(307, "请求临时URI"),
    Error(400, "请求错误"),
    InvalidToken(401, "无效的凭证"),
    NoAuth(403, "权限不足"),
    NotFount(404, "没找到对应的资源"),
    MethodNotAllowed(405, "请求方法不正确"),
    NotAcceptable(405, "不能满足请求头"),
    InterError(500, "服务器内部错误"),
    ParamError(-100, "传参错误"),
    RemoteException(-101, "远端服务器异常"),
    UNKnowError(-1, "未知错误");

    private int i;
    private String msg;

    private HttpCodeDef(int i, String msg) {
        this.i = i;
        this.msg = msg;
    }

    public int getCode() {
        return this.i;
    }

    public String getMsg() {
        return this.msg;
    }

    public static final HttpCodeDef findByHttpCode(int code) {
        HttpCodeDef[] values = values();
        HttpCodeDef[] var2 = values;
        int var3 = values.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            HttpCodeDef value = var2[var4];
            if (value.getCode() == code) {
                return value;
            }
        }

        return null;
    }
}