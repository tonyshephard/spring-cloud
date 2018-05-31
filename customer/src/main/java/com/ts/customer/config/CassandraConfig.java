package com.ts.customer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

import com.ts.customer.constance.CassandraConstance;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		return CassandraConstance.CUSTOMER_KEYSPACE.getValue();
	}
	
	@Override
	public String getContactPoints() {
	    return CassandraConstance.CUSTOMER_CONTACT_POINT.getValue();
	}

}
