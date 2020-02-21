package com.krrish.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.krrish.microservices.bean.ExchangeValue;

@Repository
public interface CurrencyExchangeRepository extends CrudRepository<ExchangeValue,Long> {
	
	ExchangeValue findByFromAndTo(String from,String to);

}
