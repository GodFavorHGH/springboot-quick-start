package com.dip.constants;

public enum AcState {
	C("C", "关闭"),
	N("N", "正常"),
	L("L", "锁定");
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
	private AcState(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}
