package com.company.designpatternsV2.builder;

public class MotorCycle implements Builder {
    private String brandName;
    private Product product;

    public MotorCycle(String brand) {
        this.brandName = brand;
        product = new Product();
    }

    @Override
    public void startUpOperations() {

    }

    @Override
    public void buildBody() {
        product.add("This is a body of a MotorCycle");
    }

    @Override
    public void insertWheels() {
        product.add("2 wheels are added");
    }

    @Override
    public void endOperations() {
        product.add(String.format("Motor cycle %s has been added", this.brandName));
    }

    @Override
    public void addHeadLights() {
        product.add("1 Headlight is added");
    }

    @Override
    public Product getVehicle() {
        return product;
    }
}
