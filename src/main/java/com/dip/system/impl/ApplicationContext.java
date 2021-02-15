package com.dip.system.impl;

import org.springframework.stereotype.Component;

import com.dip.domain.concrete.EUser;
import com.dip.system.Context;

@Component
public class ApplicationContext implements Context {

	@Override
	public EUser getUser() {
		// TODO Auto-generated method stub
		return getEuser();
	}
	
	private EUser euser;

	public EUser getEuser() {
		return euser;
	}

	public void setEuser(EUser euser) {
		this.euser = euser;
	}

}
