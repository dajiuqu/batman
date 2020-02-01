package com.bigdata.coreweb.constant;

/**
 * 结果响应状态
 */
public enum ResultStatus {
    OK(1000, "成功"),
    TOKEN_IS_VVALID(1001, "token无效"),
    EXCEPTION(201, "系统内部异常");
    private int code;
    private String msg;
    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
