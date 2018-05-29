package com.ts.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ts.customer.repository.Customer;

import static org.springframework.data.cassandra.core.query.Criteria.where;
import static org.springframework.data.cassandra.core.query.Query.query;

@RestController
public class HelloController {
    
	@Autowired
	private CassandraOperations cassandraOperations;
	
    @RequestMapping("/")
    public String index() {
    	
    	Customer bob = new Customer(33);
    	cassandraOperations.insert(bob);

    	Customer queriedBob = cassandraOperations.selectOneById(query(where("id").is(33)), Customer.class);
    	System.out.println(queriedBob);
        return "Greetings from Spring Boot!";
    }
    
}
