package com.dip.exception;

public class BizException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 7281394318996338179L;

    private String rejectCode;
    private String rejectMessage;

    public String getRejectCode() {
		return rejectCode;
	}

	public void setRejectCode(String rejectCode) {
		this.rejectCode = rejectCode;
	}

	public String getRejectMessage() {
		return rejectMessage;
	}

	public void setRejectMessage(String rejectMessage) {
		this.rejectMessage = rejectMessage;
	}

	public BizException() {

    }

    public BizException(BaseErrorInfo base) {
        super(base.getRejectMessage());
        this.rejectCode = base.getRejectCode();
        this.rejectMessage = base.getRejectMessage();
    }

    public BizException(String errorMessage) {
        super(errorMessage);
        this.rejectMessage = errorMessage;
    }

    public BizException(String rejectCode, String rejectMessage) {
        super(rejectMessage);
        this.rejectCode = rejectCode;
        this.rejectMessage = rejectMessage;
    }


}
