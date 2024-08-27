package com.company.designpatternsV2.factory;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("****Factory pattern Demo***\n");
        AnimalFactory tigerFactory = new TigerFactory();
        Animal aTiger = tigerFactory.createAnimal();
        aTiger.speak();
        aTiger.preferredAction();

        AnimalFactory dogFactory = new DogFactory();
        Animal aDog = dogFactory.createAnimal();

        aDog.speak();
        aDog.preferredAction();
    }
}
