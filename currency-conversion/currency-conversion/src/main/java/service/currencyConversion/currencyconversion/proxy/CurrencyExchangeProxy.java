package service.currencyConversion.currencyconversion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import service.currencyConversion.currencyconversion.model.CurrencyConversion;

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("currency-exchange/from/{from_curr}/to/{to_curr}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from_curr, @PathVariable String to_curr);

}
