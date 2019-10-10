package br.com.carlos.mangaorganizer.configurations;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceConfigurationTest {
	
	@Bean
	@Profile(value = "test")

	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		dataSource.setJdbcUrl("jdbc:mysql://localhost/mangaorganizer_test");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setMaxPoolSize(10);
		dataSource.setMinPoolSize(5);
		dataSource.setInitialPoolSize(5);
		
		return dataSource;
	}

}
