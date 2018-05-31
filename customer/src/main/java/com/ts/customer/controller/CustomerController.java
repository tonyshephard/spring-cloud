package com.ts.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ts.customer.service.spec.CustomerService;

@RestController
public class CustomerController {
    
	@Autowired
	private CustomerService customerService;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}
