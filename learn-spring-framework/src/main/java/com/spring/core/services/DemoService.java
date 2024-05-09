package com.spring.core.services;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String hello() {
        return "Hello service";
    }
}
