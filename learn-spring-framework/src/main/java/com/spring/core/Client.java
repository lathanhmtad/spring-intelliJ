package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
//        Vehicle vehicle = new Car();
//        Bike bike = new Bike();
//        Traveler traveler = new Traveler(bike);
//        traveler.startJourney();

        // creating spring ioc container
        // read the configuration class
        // create and manage the spring beans
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // retrieve spring beans from spring ioc container
        Car car = applicationContext.getBean(Car.class);
        car.move();

        Bike bike = applicationContext.getBean(Bike.class);
        bike.move();

        Traveler traveler = applicationContext.getBean(Traveler.class);
        traveler.startJourney();
    }
}
