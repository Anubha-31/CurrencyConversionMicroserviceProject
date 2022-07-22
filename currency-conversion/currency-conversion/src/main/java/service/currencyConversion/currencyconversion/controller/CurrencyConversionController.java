package service.currencyConversion.currencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import service.currencyConversion.currencyconversion.model.CurrencyConversion;
import service.currencyConversion.currencyconversion.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConversionService service;
	
	@GetMapping("/currency-conversion/from/{from_currency}/to/{to_currency}/quantity/{qty}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from_currency,
			@PathVariable String to_currency,
			@PathVariable BigDecimal qty) {
		
		return service.getCurrencyConversion(from_currency, to_currency, qty);
	}
	
	@GetMapping("/currency-conversion/feign/from/{from_currency}/to/{to_currency}/quantity/{qty}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from_currency,
			@PathVariable String to_currency,
			@PathVariable BigDecimal qty) {
		
		return service.getCurrencyConversionFeign(from_currency, to_currency, qty);
	}

}
