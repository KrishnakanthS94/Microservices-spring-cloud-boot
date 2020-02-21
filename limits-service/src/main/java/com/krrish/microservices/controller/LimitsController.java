package com.krrish.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krrish.microservices.bean.LimitModel;
import com.krrish.microservices.config.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("limits")
	public LimitModel getLimits() {
		return new LimitModel(configuration.getMinimum(),configuration.getMaximum());
	}
}
