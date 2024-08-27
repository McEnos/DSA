package com.company.designpatternsV2.builder;

public interface Builder {
    void startUpOperations();

    void buildBody();

    void insertWheels();

    void endOperations();

    void addHeadLights();

    Product getVehicle();
}
