package service.currencyConversion.currencyconversion.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import service.currencyConversion.currencyconversion.model.CurrencyConversion;
import service.currencyConversion.currencyconversion.proxy.CurrencyExchangeProxy;

@Service
public class CurrencyConversionService {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	public CurrencyConversion getCurrencyConversion(String from_currency, String to_currency, BigDecimal qty) {

		Map<String, String> uriVars = new HashMap<String, String>();

		uriVars.put("from_curr", from_currency);
		uriVars.put("to_curr", to_currency);
		CurrencyConversion responseBean = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from_curr}/to/{to_curr}", CurrencyConversion.class, uriVars).getBody();

		return CurrencyConversion.builder().
				calculatedAmount(responseBean.getConversionMultiple().multiply(qty)).
				quantity(qty).
				id(responseBean.getId()).
				from(from_currency).
				to(to_currency).
				conversionMultiple(responseBean.getConversionMultiple()).
				environment(env.getProperty("local.server.port")).
				build();
	}
	
	public CurrencyConversion getCurrencyConversionFeign(String from_currency, String to_currency, BigDecimal qty) {

		
		CurrencyConversion responseBean = proxy.retrieveExchangeValue(from_currency, to_currency);

		return CurrencyConversion.builder().
				calculatedAmount(responseBean.getConversionMultiple().multiply(qty)).
				quantity(qty).
				id(responseBean.getId()).
				from(from_currency).
				to(to_currency).
				conversionMultiple(responseBean.getConversionMultiple()).
				environment(responseBean.getEnvironment()).
				build();
	}
	

}
