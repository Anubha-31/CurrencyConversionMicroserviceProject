package com.anubha.microservice.service1.Limitservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties("limits-service")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Configuration {
	
	private int min;
	private int max;

}
