package com.dip.constants;

/**
 * @author 98285
 */
public enum ResultCode {
    SUCCESS(200, "成功"),
    ERROR(999, "请求参数错误"),
    API_PATH_ERROR(444, "请求接口无效"),
    FAILURE(991, "失败");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        // TODO Auto-generated constructor stub
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

}


