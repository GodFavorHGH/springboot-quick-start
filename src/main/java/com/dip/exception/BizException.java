package com.dip.exception;

public class BizException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7281394318996338179L;

	protected String rejectCode;
	protected String rejectMessage;
	public BizException() {
		
	}
	
	public BizException(BaseErrorInfo base) {
		super(base.getRejectMessage());
		this.rejectCode=base.getRejectCode();
		this.rejectMessage=base.getRejectMessage();	
	}
	
	public BizException(String errorMessage) {
		super(errorMessage);
		this.rejectMessage=errorMessage;
	}

	public BizException(String rejectCode, String rejectMessage) {
		super(rejectCode);
		this.rejectCode = rejectCode;
		this.rejectMessage = rejectMessage;
	}
	
	
}
