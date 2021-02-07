package com.dip.common;

import java.io.Serializable;

import com.dip.constants.ResultCode;
import com.dip.exception.BaseErrorInfo;

/**
 * @author 98285
 *
 */
@SuppressWarnings("rawtypes")
public class Result<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7772478485330923760L;

	private int code;
	private String message;
	private T data;
	
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 成功无结果返回
	 * @return
	 */
	public static Result success() {
		Result result= new Result();
		result.setCode(ResultCode.SUCCESS.getCode());
		result.setMessage(ResultCode.SUCCESS.getMessage());
		return result;
	}
	
	/**
	 * 成功有结果返回
	 * @return
	 */
	public Result<T> success(T data) {
		this.code=ResultCode.SUCCESS.getCode();
		this.message=ResultCode.SUCCESS.getMessage();
		this.data=data;
		return this;
	}
	
	/**
	 * 失败自定义响应码和响应信息
	 * @param code
	 * @param message
	 * @return
	 */
	public static Result failure(int code, String message) {
		Result result = new Result<>();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}
	
	/**
	 * 错误自定义响应码和响应信息
	 * @param code
	 * @param message
	 * @return
	 */
	public static Result error(int code, String message) {
		Result result = new Result<>();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}
}
