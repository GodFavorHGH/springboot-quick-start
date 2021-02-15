package com.dip.constants;

public enum PayType {

    /**
     * 支付宝
     */
    ZFB("ZFB", "支付宝"),
    /**
     * 微信
     */
    WX("WX", "微信"),
    /**
     * 银行转账
     */
    BANK("BANK", "银行转账");
    private String code;
    private String desc;

    private PayType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
