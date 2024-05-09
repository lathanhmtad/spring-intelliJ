package com.spring.core.assignment.javaconfig;

import com.spring.core.assignment.javaconfig.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {

    @Bean
    public DataSource mySQlDataSource() {
        return new MySQLDataSource();
    }

    @Bean
    public DataSource postgreSQLDataSource() {
        return new PostgreSQLDataSource();
    }

    @Bean
    public EmailService emailService() {
        return new EmailService(postgreSQLDataSource());
    }


}
