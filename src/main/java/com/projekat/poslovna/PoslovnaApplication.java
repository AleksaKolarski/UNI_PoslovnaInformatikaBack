package com.projekat.poslovna;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PoslovnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoslovnaApplication.class, args);
	}

	@Autowired
	ApplicationContext appContext;
	
	@Bean
	public Connection getConnection(){
		try {
			return ((DataSource)appContext.getBean("dataSource")).getConnection();
		} catch (BeansException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

