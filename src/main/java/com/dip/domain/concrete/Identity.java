package com.dip.domain.concrete;

import java.io.Serializable;

import com.dip.constants.IdType;

public class Identity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 997192744961002810L;

    private String idNo;
    private IdType idType;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public Identity() {

    }

    public Identity(String idNo, IdType idType) {
        this.idNo = idNo;
        this.idType = idType;
    }

}
