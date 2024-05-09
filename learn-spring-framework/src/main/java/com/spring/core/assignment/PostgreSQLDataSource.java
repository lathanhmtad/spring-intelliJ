package com.spring.core.assignment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgreSQLDataSource implements  DataSource {
    @Override
    public String[] getEmails() {
        String[] emails = {"example@gmail.com", "ramesh@gmail.com", "tony@gmail.com", "Join@gmail.com"};

        return emails;
    }
}
