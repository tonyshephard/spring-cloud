package com.ts.customer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

public class Customer {
	
	@Id
	@NonNull
	private String name;
	
	private boolean isMale;
	
	private int age;
	
	private String phoneNumber;
	
	private String[] address;
}
