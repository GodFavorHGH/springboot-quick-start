package com.dip.constants;

public enum IdType {
    P00("P00", "二代居民身份证"),
    P01("P01", "一代居民身份证");
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private IdType(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
