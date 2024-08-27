package com.company.designpatternsV2.builder;

public class Director {
    Builder builder;

    public void construct(Builder builder) {
        this.builder = builder;
        builder.startUpOperations();
        builder.buildBody();
        builder.insertWheels();
        builder.addHeadLights();
        builder.endOperations();
    }
}
