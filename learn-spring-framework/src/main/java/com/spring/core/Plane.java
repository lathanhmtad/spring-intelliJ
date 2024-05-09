package com.spring.core;

import org.springframework.stereotype.Component;

@Component("plane")
public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Plane is moving ...");
    }
}
