package com.ts.customer.constance;

public enum CassandraConstance {
	
	CUSTOMER_KEYSPACE("tsCustomer"),
	CUSTOMER_CONTACT_POINT("localhost");
	
	private String key;
	
	CassandraConstance(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return key;
	}
}
