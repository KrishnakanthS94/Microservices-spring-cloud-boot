package com.krrish.microservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.krrish.microservices.bean.ExchangeValue;
import com.krrish.microservices.repository.CurrencyExchangeRepository;

@RestController

public class CurrencyExchnageController {
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchange(@PathVariable("from") String from,@PathVariable("to") String to) throws InterruptedException
	{
		//Thread.sleep(6000);
		ExchangeValue response=repository.findByFromAndTo(from, to);
		response.setPort(environment.getProperty("local.server.port"));
		return response;
	}

}
