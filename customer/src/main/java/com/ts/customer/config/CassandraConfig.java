package com.ts.customer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		return "ts-customer";
	}
	
	public String getContactPoints() {
	    return "localhost";
	}

}
