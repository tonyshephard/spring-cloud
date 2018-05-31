package com.ts.customer.util;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.ts.customer.constance.CassandraConstance;

public class TableCreation {

	public static final void main(String[] args) {
		createTable();
	}
	
	public static void createTable() {
		Cluster cluster = Cluster.builder()
				.addContactPoints(CassandraConstance.CUSTOMER_CONTACT_POINT.getValue())
				.build();
	    Session session = cluster.connect(CassandraConstance.CUSTOMER_KEYSPACE.getValue());
	    CassandraOperations template = new CassandraTemplate(session);
		
	    template.getCqlOperations().execute("CREATE TABLE customer (name text primary key, is_male boolean, age int, phone_number text, address blob)");
	}
}
