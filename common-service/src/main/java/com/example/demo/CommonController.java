package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ClientEntity;

@RestController
@RequestMapping("/user-details")
public class CommonController {

	@Autowired
	private RestTemplate resttemp;
	@GetMapping("/{id}")
	public ClientEntity getUserDetails(@PathVariable("id") String id)
	{
	  ResponseEntity<String> name =	resttemp.exchange("http://localhost:8082/person/name/USER_1", HttpMethod.GET, null, String.class);
	  ResponseEntity<String> salary =	resttemp.exchange("http://localhost:8081/salary/USER_1", HttpMethod.GET, null, String.class);
	  ClientEntity c1 =new ClientEntity();
	  c1.setName(name.getBody());
	  c1.setSalary(salary.getBody());
	  return c1;
	}
}
