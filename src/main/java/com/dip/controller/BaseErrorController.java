package com.dip.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dip.common.Result;
import com.dip.constants.Constants;
import com.dip.constants.ResultCode;
import com.dip.exception.BizException;
import com.dip.service.WriteJnlService;

@RestController
public class BaseErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return ERROR_PATH;
	}

	@RequestMapping(path = "error")
	public Result error(HttpServletRequest request, HttpServletResponse response, BizException exception) {
		return Result.failure(ResultCode.API_PATH_ERROR.getCode(), "请求路径无效！");
	}
}
