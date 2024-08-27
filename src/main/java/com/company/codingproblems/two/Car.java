package com.company.codingproblems.two;

import java.util.Objects;

public class Car {
    private final String name;
    private final String color;

    public Car(String name, String color){
        this.name = Objects.requireNonNull(name,"Car name connote be null");
        this.color = Objects.requireNonNull(color,"Car color cannot be null");
    }
}
