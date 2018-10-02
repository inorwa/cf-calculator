package io.inorwa.cfcalculator.services;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {

	public Long fibonacci(Long n){
		if (n <= 1) return n;
		else return fibonacci(n-1) + fibonacci(n-2);
	}

}
