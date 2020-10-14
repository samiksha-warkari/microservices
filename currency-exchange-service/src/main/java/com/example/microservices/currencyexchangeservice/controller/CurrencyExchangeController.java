package com.example.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencyexchangeservice.Configuration;
import com.example.microservices.currencyexchangeservice.model.CurrencyExchangeConfiguration;
import com.example.microservices.currencyexchangeservice.model.ExchangeValue;
import com.example.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Configuration configuration;
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	// @GetMapping("/currency-exchange-limit")
	// public CurrencyExchangeConfiguration retrieveLimitsFromConfiguration() {
	// return new CurrencyExchangeConfiguration(configuration.getMaximum(),
	// configuration.getMinimum());
	// }

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue=exchangeValueRepository.findByFromAndTo(from, to);
		return exchangeValue;
	}
}
