package com.ts.customer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

import com.ts.customer.domain.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private ReactiveCassandraOperations reactiveCassandraOperations;

	@Override
	public void createCustomers(CustomerDto dto) {
		reactiveCassandraOperations.insert(dto);
	}

	@Override
	public Flux<CustomerDto> fetchCustomer(List<String> names) {
		return reactiveCassandraOperations.select(Query.query(Criteria.where("name").in(names)), CustomerDto.class);
	}
	
}
