package com.psja.MutlipleDatabaseUsingJPA.config;

import java.util.Map;
import java.util.HashMap;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableJpaRepositories( basePackages = "com.psja.MutlipleDatabaseUsingJPA.persistence.employee", 
							entityManagerFactoryRef="EmployeeEntityManager", 
							transactionManagerRef = "employeeTransactionManager" )
public class SecondConfiguration {

	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean EmployeeEntityManager() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(EmployeeDataSource());
		emf.setPackagesToScan(new String[] {"com.psja.MutlipleDatabaseUsingJPA.entity.employee"});
		
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		
		Map<String, Object> map = new HashMap<>();
		map.put("hibernate.hbm2ddl.auto", "validate");
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		emf.setJpaPropertyMap(map);
		
		return emf;
	}
	
	
	@Bean
	public DriverManagerDataSource EmployeeDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setUrl(env.getProperty("connection.data.myConnection2.url"));
		driverManagerDataSource.setUsername(env.getProperty("connection.data.myConnection2.username"));
		driverManagerDataSource.setPassword(env.getProperty("connection.data.myConnection2.password"));
		driverManagerDataSource.setDriverClassName(env.getProperty("connection.data.myConnection2.driverClassName"));
		
		return driverManagerDataSource;
	}
	
	@Bean
	public PlatformTransactionManager employeeTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(EmployeeEntityManager().getObject());
		
		
		return transactionManager;
	}
}
