package com.dip.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource(value="classpath:extras-config.properties")
public class ExtrasConfig {

	@Getter
	@Setter
	private int defaultPageSize;
	
}
