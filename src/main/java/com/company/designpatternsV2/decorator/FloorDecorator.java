package com.company.designpatternsV2.decorator;

public class FloorDecorator extends AbstractDecorator {
    public void makeHouse() {
        super.makeHouse();
        System.out.println("***Floor decorator in in action***");
        addFloor();
    }

    private void addFloor() {
        System.out.println("I am making an additional floor on top of it");
    }
}
