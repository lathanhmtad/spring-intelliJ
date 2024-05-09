package com.example.repository;

public class ClassB implements InterfaceA, InterfaceRepository {
    @Override
    public void move() {
        System.out.println("Moving ...");
    }
}
