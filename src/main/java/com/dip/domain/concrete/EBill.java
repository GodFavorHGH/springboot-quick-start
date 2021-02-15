package com.dip.domain.concrete;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.dip.constants.PayType;

public class EBill implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2381465355552737255L;
    private int jnlNo;//流水
    private int userId;//
    private String title;
    private String ioType;//收支类型 I-入账 O-出账
    private PayType payType;//支付类型
    private BigDecimal amount;
    private String content;
    private Date transDate;
    private Date recordDate;
    private Timestamp createTime;
    private Timestamp updateTime;

    public int getJnlNo() {
        return jnlNo;
    }

    public void setJnlNo(int jnlNo) {
        this.jnlNo = jnlNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIoType() {
        return ioType;
    }

    public void setIoType(String ioType) {
        this.ioType = ioType;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public EBill() {
    }

    public EBill(int jnlNo, int userId, String title, String ioType, PayType payType, BigDecimal amount, String content,
                 Date transDate, Date recordDate, Timestamp createTime, Timestamp updateTime) {
        super();
        this.jnlNo = jnlNo;
        this.userId = userId;
        this.title = title;
        this.ioType = ioType;
        this.payType = payType;
        this.amount = amount;
        this.content = content;
        this.transDate = transDate;
        this.recordDate = recordDate;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

}
