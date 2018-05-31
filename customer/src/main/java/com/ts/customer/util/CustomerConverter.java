package com.ts.customer.util;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import com.ts.customer.domain.CustomerDto;
import com.ts.customer.entity.CustomerEntity;

@Slf4j
public class CustomerConverter {

	private CustomerConverter() {
	}
	
	public static Optional<CustomerEntity> convertToEntity(CustomerDto dto) {
		try {
			return Optional.of(
					CustomerEntity.builder()
						.name(dto.getName())
						.isMale(dto.isMale())
						.age(dto.getAge())
						.phoneNumber(dto.getPhoneNumber())
						.address(dto.getAddress())
						.build());
		} catch(Exception e) {
			log.error("Fail to convert to customer entity", e);
			return Optional.empty();
		}
	}
	
	public static CustomerDto convertToDto(CustomerEntity entity) {
		return CustomerDto.builder()
				.name(entity.getName())
				.isMale(entity.isMale())
				.age(entity.getAge())
				.phoneNumber(entity.getPhoneNumber())
				.address(entity.getAddress())
				.build();
	}
	
}
