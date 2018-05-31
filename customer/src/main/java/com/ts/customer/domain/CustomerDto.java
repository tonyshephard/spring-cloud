package com.ts.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.SASI;
import org.springframework.data.cassandra.core.mapping.Table;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class CustomerDto {
	
	@PrimaryKey
	private String name;
	
	@SASI
	private boolean isMale;
	
	@SASI
	private int age;
	
	private String phoneNumber;
	
	private String[] address;

}
