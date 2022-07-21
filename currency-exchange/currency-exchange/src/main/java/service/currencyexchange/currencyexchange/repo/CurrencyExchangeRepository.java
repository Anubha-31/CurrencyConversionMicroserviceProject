package service.currencyexchange.currencyexchange.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import service.currencyexchange.currencyexchange.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
