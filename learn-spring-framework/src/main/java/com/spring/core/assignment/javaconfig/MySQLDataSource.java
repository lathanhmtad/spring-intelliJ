package com.spring.core.assignment.javaconfig;

import org.springframework.stereotype.Component;


public class MySQLDataSource implements DataSource {

    @Override
    public String[] getEmails() {
        String[] emails = {"example@gmail.com", "ramesh@gmail.com", "tony@gmail.com", "Join@gmail.com"};

        return emails;
    }
}
