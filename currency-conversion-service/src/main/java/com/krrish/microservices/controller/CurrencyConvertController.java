package com.krrish.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.krrish.microservices.bean.CurrencyConversionBean;
import com.krrish.microservices.feign.CurrencyExchangeServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class CurrencyConvertController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, 
			@PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) 
	{
		String url="http://localhost:8600/currency-exchange/from/{from}/to/{to}";
		Map<String,String> uriVariables= new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> resposneEnity= new RestTemplate().getForEntity(url, CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean response= resposneEnity.getBody();
		
		return new CurrencyConversionBean(from, to, response.getConverisonMultiple(), response.getId(), 
				quantity, quantity.multiply(response.getConverisonMultiple()), response.getPort());
		
	}
	
	@HystrixCommand(fallbackMethod="defaultResponse",
			commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyViaFeign(@PathVariable("from") String from, 
			@PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) 
	{
		CurrencyConversionBean response = proxy.retrieveExchange(from, to);
		return new CurrencyConversionBean(from, to, response.getConverisonMultiple(), response.getId(), 
				quantity, quantity.multiply(response.getConverisonMultiple()), response.getPort());
		
	}
	
	public CurrencyConversionBean defaultResponse(@PathVariable("from") String from, 
			@PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {
		return new CurrencyConversionBean(from, to, BigDecimal.valueOf(70), 99L, quantity, 
				BigDecimal.valueOf(99), "default port from fallback");
	}

}
