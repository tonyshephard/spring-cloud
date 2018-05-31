package com.ts.customer.repository;

import java.util.List;

import reactor.core.publisher.Flux;

import com.ts.customer.domain.CustomerDto;

public interface CustomerDao {

	/**
	 * create a new customer info
	 */
	public void createCustomers(CustomerDto dto);
	
	/**
	 * fetch customer
	 */
	public Flux<CustomerDto> fetchCustomer(List<String> name);
}
