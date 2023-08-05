package com.gs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.gs.dao")
public class PersistanceConfig {

	@Bean(name="hkDs")
	public HikariDataSource createHKDatasource() {
		HikariDataSource hkDs=new HikariDataSource();
		hkDs.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hkDs.setJdbcUrl("jdbc:mysql://localhost:3306/rani_schema");
		hkDs.setUsername("root");
		hkDs.setPassword("Rani@123");
		return hkDs;
	}
	
	@Bean(name="jt")
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createHKDatasource());
	}
}
