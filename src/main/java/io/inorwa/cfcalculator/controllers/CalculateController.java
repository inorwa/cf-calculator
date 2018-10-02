package io.inorwa.cfcalculator.controllers;

import io.inorwa.cfcalculator.services.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class CalculateController {

	private CalculateService calculateService;

	@Autowired
	public CalculateController(CalculateService calculateService) {
		this.calculateService = calculateService;
	}

	@GetMapping("/fibonacci")
	public ResponseEntity<Long> fibonacci(@RequestParam(name = "value") Long value){
		log.info("fibonacci for " + value);
		return new ResponseEntity<>(calculateService.fibonacci(value), HttpStatus.OK);

	}

}
