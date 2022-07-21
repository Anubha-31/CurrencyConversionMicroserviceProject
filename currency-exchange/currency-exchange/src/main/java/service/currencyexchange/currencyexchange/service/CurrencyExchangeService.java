package service.currencyexchange.currencyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import service.currencyexchange.currencyexchange.model.CurrencyExchange;
import service.currencyexchange.currencyexchange.repo.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment envrionment;

	public CurrencyExchange getExchangeRate(String fromCurrency, String toCurrency) {

		CurrencyExchange rateObj = repository.findByFromAndTo(fromCurrency, toCurrency);

		if (rateObj == null) {
			throw new RuntimeException("Unable to find the data for " + fromCurrency + " to " + toCurrency);
		} else {
			rateObj.setEnvironment(envrionment.getProperty("local.server.port"));
		}

		return rateObj;

	}

}
