package com.dip.aspect;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.dip.constants.Constants;
import com.dip.constants.ResultCode;
import com.dip.domain.concrete.EUser;
import com.dip.exception.BizException;
import com.dip.service.WriteJnlService;
import com.dip.system.impl.ApplicationContext;
import com.dip.utils.DataConvertUtil;
import com.dip.utils.DateUtil;

@Component
@Aspect
public class WriteJournalAspect {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private WriteJnlService service;
	
	@Autowired
	HttpServletRequest request;
	
	@Pointcut("@annotation(com.dip.annotation.WriteJournal)")
//	@Pointcut("execution(* com.dip..*.*(..))")
	public void WriteJournalCut() {
		
	}
	
	@Before("WriteJournalCut()")
	public void before() {
		
	}
	
	@Around("WriteJournalCut()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Object args[] = joinPoint.getArgs();
		String params[] = signature.getParameterNames();
		Object o = null;
		Map map = new HashMap();
		map.put(Constants.TRANSCODE, request.getServletPath());
		map.put(Constants.LOCALADDR, request.getLocalAddr());
		map.put(Constants.REMOTEADDR, request.getRemoteAddr());
		map.put(Constants.LOCALNAME, request.getLocalName());
		map.put(Constants.TRANSDATE, DateUtil.getCurrentDate());
		try {
			o = joinPoint.proceed();
    		map.put(Constants.RETURNCODE, ResultCode.SUCCESS.getCode());
    		map.put(Constants.RETURNMSG, ResultCode.SUCCESS.getMessage());
		} catch (BizException e) {
			 //TODO: handle exception
    		map.put(Constants.RETURNCODE, e.getRejectCode());
    		map.put(Constants.RETURNMSG, e.getRejectMessage());
		} catch (SQLSyntaxErrorException e) {
			 //TODO: handle exception
    		map.put(Constants.RETURNCODE, e.getErrorCode());
    		map.put(Constants.RETURNMSG, e.getMessage().substring(0,60));
		} catch (Exception e) {
			 //TODO: handle exception
    		map.put(Constants.RETURNCODE, "9999");
    		map.put(Constants.RETURNMSG, e.getMessage().substring(0,60));
		} finally {
			if (null!=applicationContext.getUser()) {
				map.put(Constants.USERID, applicationContext.getUser().getId());
			}
			service.writeJnl(map);
		}
		EUser e2 = applicationContext.getUser();
		return o;
	}
	
	@AfterReturning("WriteJournalCut()")
	public void doAfterReturning() {
		
	}
	
	private Map convertData(String params) {
		return DataConvertUtil.convertJsonToMap(params);
	}
	
	
}
