package com.anubha.microservice.service1.Limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anubha.microservice.service1.Limitservice.Configuration;
import com.anubha.microservice.service1.Limitservice.model.Limits;

@RestController
public class LimitsServiceController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {

		Limits limit = Limits.builder().max(config.getMax()).min(config.getMin()).build();
		return limit;

	}

}
