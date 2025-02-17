package com.example.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencyexchangeservice.Configuration;
import com.example.microservices.currencyexchangeservice.model.ExchangeValue;
import com.example.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Configuration configuration;
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	@Autowired
	private Environment env;
	// @GetMapping("/currency-exchange-limit")
	// public CurrencyExchangeConfiguration retrieveLimitsFromConfiguration() {
	// return new CurrencyExchangeConfiguration(configuration.getMaximum(),
	// configuration.getMinimum());
	// }

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue=exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
	}
}
