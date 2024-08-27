package com.company.designpatternsV2.decorator;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        System.out.println("***Decorator pattern Demo***");
        ConcreteComponent withoutDecorator = new ConcreteComponent();
        withoutDecorator.makeHouse();
        System.out.println("__________________________________");
        System.out.println("Using floor decorator now.");
        FloorDecorator floorDecorator = new FloorDecorator();
        floorDecorator.setComponent(withoutDecorator);
        floorDecorator.makeHouse();
        System.out.println("___________________________________");
        System.out.println("Using a paint decorator now.");
        PaintDecorator paintDecorator = new PaintDecorator();

        paintDecorator.setComponent(floorDecorator);
        paintDecorator.makeHouse();
    }
}
