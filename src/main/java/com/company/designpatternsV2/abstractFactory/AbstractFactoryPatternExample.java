package com.company.designpatternsV2.abstractFactory;

public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        AnimalFactory animalFactory;
        Dog dog;
        Tiger tiger;
        System.out.println("***Abstract Factory Pattern Demo****\n");
        animalFactory = new WildAnimalFactory();
        dog = animalFactory.createDog();
        dog.speak();
        dog.preferredAction();

        tiger = animalFactory.createTiger();
        tiger.speak();
        tiger.preferredAction();
        System.out.println("***************************************");
        animalFactory = new PetAnimalFactory();
        dog = animalFactory.createDog();
        dog.speak();
        dog.preferredAction();
        tiger = animalFactory.createTiger();
        tiger.speak();
        tiger.preferredAction();
    }
}
