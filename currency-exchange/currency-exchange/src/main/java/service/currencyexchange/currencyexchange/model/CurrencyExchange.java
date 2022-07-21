package service.currencyexchange.currencyexchange.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CurrencyExchange {
	
	@Id
	@SequenceGenerator(
			allocationSize = 1,
			name = "currency_exchange_seq",
			sequenceName = "Currency_Sequence"
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "from_currency")
	private String from;
	@Column(name = "to_currency")
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;

}
