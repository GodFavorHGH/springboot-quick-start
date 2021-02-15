package com.dip.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dip.common.Result;
import com.dip.constants.Constants;
import com.dip.constants.ResultCode;
import com.dip.service.WriteJnlService;
import com.dip.system.impl.ApplicationContext;
import com.dip.utils.DateUtil;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@Autowired
	private WriteJnlService service;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@ResponseBody
//	@ExceptionHandler(BizException.class)
	@ExceptionHandler(BizException.class)
	public Result globalExceptionProcess(HttpServletRequest request, HttpServletResponse response, BizException exception) {
		Map map = new HashMap();
		map.put(Constants.TRANSCODE, request.getServletPath());
		map.put(Constants.RETURNCODE, exception.getRejectCode());
		map.put(Constants.RETURNMSG, exception.getRejectMessage());
		map.put(Constants.LOCALADDR, request.getLocalAddr());
		map.put(Constants.REMOTEADDR, request.getRemoteAddr());
		map.put(Constants.LOCALNAME, request.getLocalName());
		map.put(Constants.TRANSDATE, DateUtil.getCurrentDate());
		if (null!=applicationContext.getUser()) {
			map.put(Constants.USERID, applicationContext.getUser().getId());
		}
		service.writeJnl(map);
		return Result.failure(Integer.parseInt(exception.getRejectCode()), exception.getRejectMessage());
	}
	
}
