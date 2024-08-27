package com.company.designpatternsV2.decorator;

public class PaintDecorator extends AbstractDecorator {
    public void makeHouse() {
        super.makeHouse();
        System.out.println("***Paint decorator is in action now***");
        paintHouse();
    }

    private void paintHouse() {
        System.out.println("Now I am painting the house.");
    }
}
