package com.boot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {

	@Primary
	@Bean("DB1")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource datasource() {
	      return DataSourceBuilder.create().build();
	}
	@Bean("DB2")
	@ConfigurationProperties(prefix = "spring.flyway")
	@FlywayDataSource
	public DataSource flywayDataSource() {
	      return DataSourceBuilder.create().build();
	}

}
