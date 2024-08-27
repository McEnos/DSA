package com.company.designpatternsV2.builder;

/**
 * <a href="https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java">Builder Design Pattern</a>
 * https://www.digitalocean.com/community/tags/design-patterns?page=3
 */
public class BuilderPatternExample {
    public static void main(String[] args) {
        Director director = new Director();

        Builder fordCar = new Car("Ford");


        Builder hondaMotorCycle = new MotorCycle("Honda");

        director.construct(fordCar);
        Product p1 = fordCar.getVehicle();

        p1.showProduct();

        director.construct(hondaMotorCycle);
        Product p2 = hondaMotorCycle.getVehicle();
        p2.showProduct();
    }
}
