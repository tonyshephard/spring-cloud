package com.ts.customer.service.spec;

import java.util.List;
import java.util.concurrent.Future;
import reactor.core.publisher.Flux;
import com.ts.customer.entity.CustomerEntity;

public interface CustomerService {
	
	/**
	 * create a new customer info
	 */
	public void createCustomers(CustomerEntity entity);
	
	/**
	 * fetch customers
	 */
	public Flux<CustomerEntity> fetchCustomer(List<String> names, Integer size);
	
	/**
	 * fetch customers in an asynchronized way
	 */
	public List<CustomerEntity> fetchCustomerInBlocking(List<String> names, Integer size);
	
	/**
	 * fetch customers in an asynchronized way, and return the {@link Future}
	 */
	public Future<CustomerEntity> fetchLastCustomerInFuture(List<String> names, Integer size);
}
