package com.dip;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.dip.annotation.WriteJournal;
import com.dip.constants.Constants;
import com.dip.constants.ResultCode;
import com.dip.exception.BizException;
import com.dip.service.WriteJnlService;
import com.dip.system.impl.ApplicationContext;
import com.dip.utils.DateUtil;

@Component
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Filter implements javax.servlet.Filter {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private WriteJnlService service;
	
	@Autowired
	private ApplicationContext applicationContext;
	//@WriteJournal
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
    	List<Map> products = (List<Map>) redisTemplate.opsForValue().get("products");
        // TODO Auto-generated method stub
    	HttpServletRequest request = (HttpServletRequest) req;
    	String api = request.getServletPath();
    	boolean isAllowed = false;
    	if (products!=null&&products.size()>0) {
			for (int i = 0,len=products.size(); i < len; i++) {
				if (api.equals(products.get(i).get("TransCode"))) {
					isAllowed = true;
				}
			}
		}
    	request.getServletPath();
        HttpServletResponse response = (HttpServletResponse) res;
        if (!isAllowed) {
        	//若请求的路径不存在，报错拦截
        	Map map = new HashMap();
    		map.put(Constants.TRANSCODE, request.getServletPath());
    		map.put(Constants.RETURNCODE, ResultCode.API_PATH_ERROR.getCode());
    		map.put(Constants.RETURNMSG, ResultCode.API_PATH_ERROR.getMessage());
    		map.put(Constants.LOCALADDR, request.getLocalAddr());
    		map.put(Constants.REMOTEADDR, request.getRemoteAddr());
    		map.put(Constants.LOCALNAME, request.getLocalName());
    		map.put(Constants.TRANSDATE, DateUtil.getCurrentDate());
    		if (null!=applicationContext.getUser()) {
    			map.put(Constants.USERID, applicationContext.getUser().getId());
			}
    		service.writeJnl(map);
			throw new BizException(String.valueOf(ResultCode.API_PATH_ERROR.getCode()), ResultCode.API_PATH_ERROR.getMessage());
        }

        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");

        response.setHeader("Access-Control-Max-Age", "3600");

        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");


        chain.doFilter(req, res);
    }

}
