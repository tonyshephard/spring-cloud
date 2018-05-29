package com.ts.customer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.ts.customer.*")
@Import(value= {CassandraConfig.class})
public class CustomerConfig {

}
