package com.ts.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

	@NonNull
	private String name;
	
	private boolean isMale;
	
	private int age;
	
	private String phoneNumber;
	
	private String[] address;
}
