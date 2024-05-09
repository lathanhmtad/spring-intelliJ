package com.example.springannotations.controller;

import com.example.springannotations.service.Pizza;
import com.example.springannotations.service.VegPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("pizzaDemo")
public class PizzaController {
//    @Autowired
//    private VegPizza vegPizza;

    private Pizza pizza;

    public PizzaController(Pizza pizza) {
        this.pizza = pizza;
    }

//    public PizzaController(@Qualifier("nonVegPizza") Pizza pizza) {
//        this.pizza = pizza;
//    }

//    public PizzaController(Pizza pizza) {
//        this.pizza = pizza;
//    }

//    @Autowired
//    public void setVegPizza(VegPizza vegPizza) {
//        this.vegPizza = vegPizza;
//    }

    public String getPizza() {
        return pizza.getPizza();
    }

    public void init() {
        System.out.println("Initialization logic");
    }

    public void destroy() {
        System.out.println("Destruction logic");
    }
}
