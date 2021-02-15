package com.dip.domain.concrete;

public class Rule {

    private String ruleId;
    private String userType;
    private String ruleType;
    private String ruleDef;
    private String nameSpace;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleDef() {
        return ruleDef;
    }

    public void setRuleDef(String ruleDef) {
        this.ruleDef = ruleDef;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public Rule() {

    }

    public Rule(String ruleId, String userType, String ruleType, String ruleDef, String nameSpace) {
        super();
        this.ruleId = ruleId;
        this.userType = userType;
        this.ruleType = ruleType;
        this.ruleDef = ruleDef;
        this.nameSpace = nameSpace;
    }


}
