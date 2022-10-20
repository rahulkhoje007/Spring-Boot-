package com.amva.demorestapi.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class Salary {

	@GetMapping("{id}")
	public String getSalary(@PathVariable("id") String id) {
		if (id.equals("USER_1"))
			return "70000";
		throw new RuntimeException();
	}

}
