package br.com.carlos.mangaorganizer.configurations;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JpaConfiguration {
	
	//Aqui vou fazer um autowired com qual bean? Com a annotation @Qualifier indicamos o nome do 
	// @Bean qualificado para a injeção(no caso"dev")
	@Autowired
	@Qualifier("dev")
	private Properties properties;
	
	@Autowired
	private DataSource dataSource;
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(properties);
		factoryBean.setPackagesToScan("br.com.carlos.mangaorganizer.models");
		factoryBean.setDataSource(dataSource);
		
		return factoryBean;
	}
	
	
	//Vai receber um EntityManagerFactory... Qual � o EMF que eu tenho como Bean?? Olhar para cima ^
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory managerFactory) {
		return new JpaTransactionManager();
	}

}
