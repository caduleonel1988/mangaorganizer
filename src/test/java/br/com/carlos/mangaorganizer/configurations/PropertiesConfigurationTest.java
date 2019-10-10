package br.com.carlos.mangaorganizer.configurations;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PropertiesConfigurationTest {

	// Propriedades para configura��o do Hibernate
	@Bean(name = "test")
	@Profile(value = "test")
	public Properties aditionalProperties(Properties properties) {
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		return properties;
	}
}
