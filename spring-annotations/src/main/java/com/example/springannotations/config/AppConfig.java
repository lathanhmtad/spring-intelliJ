package com.example.springannotations.config;

import com.example.springannotations.controller.PizzaController;
import com.example.springannotations.service.NonVegPizza;
import com.example.springannotations.service.Pizza;
import com.example.springannotations.service.VegPizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration

public class AppConfig {

//    @Bean(name = "vegPizzaBean")
    @Bean
    @Lazy
    public Pizza vegPizza() {
        return new VegPizza();
    }

    @Bean
    public Pizza nonVegPizza() {
        return new NonVegPizza();
    }

    @Bean(name = "pizzaDemo", initMethod = "init", destroyMethod = "destroy")
    public PizzaController pizzaController() {
        return new PizzaController(nonVegPizza());
    }


}
