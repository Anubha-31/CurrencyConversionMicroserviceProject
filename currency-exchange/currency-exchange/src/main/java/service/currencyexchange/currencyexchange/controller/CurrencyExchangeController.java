package service.currencyexchange.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import service.currencyexchange.currencyexchange.model.CurrencyExchange;
import service.currencyexchange.currencyexchange.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	@Autowired
	CurrencyExchangeService service;

	@GetMapping("currency-exchange/from/{from_curr}/to/{to_curr}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from_curr, @PathVariable String to_curr) {

		return service.getExchangeRate(from_curr, to_curr);

	}
}
