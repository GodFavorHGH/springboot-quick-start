package com.dip.domain.concrete;

import java.io.Serializable;

import com.dip.constants.AcState;
import com.dip.constants.AcType;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6809352946267911915L;

	
	private int id;
	private int userId;
	private String acNo;
	private String acName;
	private AcType acType;
	private AcState acState;
	private EUser user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public AcType getAcType() {
		return acType;
	}
	public void setAcType(AcType acType) {
		this.acType = acType;
	}
	public AcState getAcState() {
		return acState;
	}
	public void setAcState(AcState acState) {
		this.acState = acState;
	}
	
	public EUser getUser() {
		return user;
	}
	public void setUser(EUser user) {
		this.user = user;
	}
	public Account() {
		
	}
	public Account(int id, int userId, String acNo, String acName, AcType acType, AcState acState, EUser user) {
		super();
		this.id = id;
		this.userId = userId;
		this.acNo = acNo;
		this.acName = acName;
		this.acType = acType;
		this.acState = acState;
		this.user = user;
	}
	
}
