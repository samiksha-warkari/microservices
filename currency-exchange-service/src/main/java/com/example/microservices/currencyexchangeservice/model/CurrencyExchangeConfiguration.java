package com.example.microservices.currencyexchangeservice.model;

public class CurrencyExchangeConfiguration {
	private int maximum;
	private int minimum;

	public CurrencyExchangeConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyExchangeConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

}
