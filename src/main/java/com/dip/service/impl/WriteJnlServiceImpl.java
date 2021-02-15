package com.dip.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dip.mapper.WriteJnlMapper;
import com.dip.service.WriteJnlService;

@Service
public class WriteJnlServiceImpl implements WriteJnlService {

	@Autowired
	private WriteJnlMapper mapper;
	@Override
	public int writeJnl(Map map) {
		// TODO Auto-generated method stub
		return mapper.writeJnl(map);
	}

	@Override
	public int updateJnl(Map map) {
		// TODO Auto-generated method stub
		return mapper.updateJnl(map);
	}

}
