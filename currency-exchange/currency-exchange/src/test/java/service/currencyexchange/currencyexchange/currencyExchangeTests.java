package service.currencyexchange.currencyexchange;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import service.currencyexchange.currencyexchange.model.CurrencyExchange;
import service.currencyexchange.currencyexchange.repo.CurrencyExchangeRepository;

@SpringBootTest
public class currencyExchangeTests {
	
	@Autowired
	CurrencyExchangeRepository repository;
	
	@Test
	public void addData() {
		CurrencyExchange obj = CurrencyExchange.builder().
				conversionMultiple(BigDecimal.valueOf(75)).
				to("USD").
				from("INR").
				build();
		repository.save(obj);
	}

}
