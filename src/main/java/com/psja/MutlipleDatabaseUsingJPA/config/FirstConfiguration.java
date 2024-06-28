package com.psja.MutlipleDatabaseUsingJPA.config;

import java.util.Map;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableJpaRepositories( basePackages = "com.psja.MutlipleDatabaseUsingJPA.persistence.user", 
							entityManagerFactoryRef="UserEntityManager", 
							transactionManagerRef = "userTransactionManager" )
public class FirstConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean UserEntityManager() {
		
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = 
									new LocalContainerEntityManagerFactoryBean();
		
		localContainerEntityManagerFactoryBean.setDataSource(userDataSource());
		localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] {"com.psja.MutlipleDatabaseUsingJPA.entity.user"});
		
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		
		Map<String, Object> map = new HashMap<>();
		map.put("hibernate.hbm2ddl.auto", "validate");
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			
		localContainerEntityManagerFactoryBean.setJpaPropertyMap(map);
		
		return localContainerEntityManagerFactoryBean;
	}
	
	
	
	@Bean
	@Primary
	public DataSource userDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("connection.data.myConnection1.driverClassName"));
		dataSource.setUsername(env.getProperty("connection.data.myConnection1.username"));
		dataSource.setPassword(env.getProperty("connection.data.myConnection1.password"));
		dataSource.setUrl(env.getProperty("connection.data.myConnection1.url"));
		
		return dataSource;
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager userTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(UserEntityManager().getObject());
		
		return jpaTransactionManager;
	}
}
