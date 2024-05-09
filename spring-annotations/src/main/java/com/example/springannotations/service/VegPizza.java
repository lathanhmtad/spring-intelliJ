package com.example.springannotations.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component

public class VegPizza implements Pizza {

    @Override
    public String getPizza() {
        return "Veg Pizza";
    }
}
