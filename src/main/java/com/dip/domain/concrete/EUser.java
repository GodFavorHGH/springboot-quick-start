package com.dip.domain.concrete;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.dip.constants.IdType;

public class EUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8255982570461506650L;

	private int id;
	private String password;
	private String name;
	private String idNo;
	private IdType idType;
	private String phone;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String status;
	private Identity identity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public EUser() {
		
	}
	private List<Account> acList;
	public List<Account> getAcList() {
		return acList;
	}
	public void setAcList(List<Account> acList) {
		this.acList = acList;
	}
	public EUser(int id, String password, String name, String idNo, IdType idType, String phone, Timestamp createTime,
			Timestamp updateTime, String status, Identity identity, List<Account> acList) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.idNo = idNo;
		this.idType = idType;
		this.phone = phone;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.identity = identity;
		this.acList = acList;
	}
	
}
