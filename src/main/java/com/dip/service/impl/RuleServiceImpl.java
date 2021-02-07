package com.dip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dip.domain.concrete.Rule;
import com.dip.mapper.RuleMapper;
import com.dip.service.RuleService;

public class RuleServiceImpl implements RuleService {

	@Autowired
	private RuleMapper ruleMapper;
	
	@Override
	public Rule getRootRule() {
		// TODO Auto-generated method stub
		return ruleMapper.getRootRule();
	}

}
