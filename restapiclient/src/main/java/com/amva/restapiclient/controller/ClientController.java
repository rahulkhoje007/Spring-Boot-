package com.amva.restapiclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/person")
public class ClientController {

	// private RestTemplate restemp;

	@GetMapping("/name/{iD}")
	public String getName(@PathVariable("iD") String id) {
		if (id.equals("USER_1"))
			return "Rahul";
		throw new RuntimeException();
	}

}