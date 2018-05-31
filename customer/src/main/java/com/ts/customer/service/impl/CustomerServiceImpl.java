package com.ts.customer.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

import com.ts.customer.constance.CustomerDafaultSetting;
import com.ts.customer.domain.CustomerDto;
import com.ts.customer.entity.CustomerEntity;
import com.ts.customer.repository.CustomerDao;
import com.ts.customer.service.spec.CustomerService;
import com.ts.customer.util.CustomerConverter;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void createCustomers(CustomerEntity entity) {
		CustomerDto dto =  CustomerConverter.convertToDto(entity);
		customerDao.createCustomers(dto);
	}

	@Override
	public Flux<CustomerEntity> fetchCustomer(List<String> names, Integer size) {
		int fetchSize = Objects.isNull(size) ? CustomerDafaultSetting.DEFAULT_FETCH_SIZE : size;
		return customerDao.fetchCustomer(names)
				.map(dto -> CustomerConverter.convertToEntity(dto).orElse(null))
				.take(fetchSize);
	}

	@Override
	public List<CustomerEntity> fetchCustomerInBlocking(List<String> names, Integer size) {
		return fetchCustomer(names, size).toStream().collect(Collectors.toList());
	}

	@Override
	public Future<CustomerEntity> fetchLastCustomerInFuture(List<String> names, Integer size) {
		return fetchCustomer(names, size).last().toFuture();
	}

}
