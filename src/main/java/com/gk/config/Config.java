package com.gk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.gk")
public class Config {
	@Bean
	public DriverManagerDataSource getDataResource() {
		DriverManagerDataSource dataResource = new DriverManagerDataSource();
		dataResource.setDriverClassName("com.mysql.jdbc.Driver");
		dataResource.setUrl("jdbc:mysql://localhost:3306/world?useSSL=false");
		dataResource.setUsername("root");
		dataResource.setPassword("boot");
		return dataResource;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataResource());
		return jdbcTemplate;
	}
}
