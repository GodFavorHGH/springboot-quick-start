package com.dip.constants;

public enum AcType {
    /**
     * 借记卡
     */
    C1("C1", "借记卡"),
    P1("P1", "存折");
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

    private AcType(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
