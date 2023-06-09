package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
public class JdbcAppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/db"); //set url
		ds.setUsername("--");
		ds.setPassword("--");
		return ds;
	}
	
	@Bean
	public DataSource dataSource1() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/db"); //set url
		ds.setUsername("--");
		ds.setPassword("--");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("dataSource1")DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
