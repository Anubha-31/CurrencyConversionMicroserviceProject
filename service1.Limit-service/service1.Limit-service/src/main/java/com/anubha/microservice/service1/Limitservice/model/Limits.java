package com.anubha.microservice.service1.Limitservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Limits {
	
	private int min;
	private int max;	

}
