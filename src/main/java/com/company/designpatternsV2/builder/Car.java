package com.company.designpatternsV2.builder;

public class Car implements Builder {
    private String brandName;
    private Product product;

    public Car(String brand) {
        product = new Product();
        this.brandName = brand;
    }

    @Override
    public void startUpOperations() {
        product.add(String.format("Car model is : %s", this.brandName));
    }

    @Override
    public void buildBody() {
        product.add("This is a body of a car");
    }

    @Override
    public void insertWheels() {
        product.add("This is a car wheel");
    }

    @Override
    public void endOperations() {
    }

    @Override
    public void addHeadLights() {
        product.add("2 Headlights are added");
    }

    @Override
    public Product getVehicle() {
        return product;
    }
}
