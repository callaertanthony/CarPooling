package com.rizomm.carpooling.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//informer que le bean sert à la configuration de spring
@Configuration	 
// importer un fichier 
@PropertySource("classpath:com/rizomm/carpooling/config/properties/data/jdbc.properties")
public class DataSourceConfig {
	
	// ajouter une dépendance
	@Autowired 
	private Environment env;

	// définir un bean spring
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();	
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));    	
		return dataSource;
	}
}
