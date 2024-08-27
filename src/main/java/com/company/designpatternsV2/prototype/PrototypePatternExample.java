package com.company.designpatternsV2.prototype;

public class PrototypePatternExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Prototype Pattern Demo");
        BasicCar nano = new Nano("Green Nano");
        nano.basePrice = 100000;

        BasicCar ford = new Ford("Ford Yellow");
        ford.basePrice = 5000000;


        BasicCar bc1;

        bc1 = nano.clone();


        bc1.onRoadPrice = nano.basePrice + BasicCar.setAdditionalPrice();
        System.out.println("Car is " + bc1.modelName + " and it's price is " + bc1.onRoadPrice);

        bc1 = ford.clone();

        bc1.onRoadPrice = ford.basePrice + BasicCar.setAdditionalPrice();
        System.out.println("Car is: " + bc1.modelName + " and it's price is " + bc1.onRoadPrice);
    }
}
