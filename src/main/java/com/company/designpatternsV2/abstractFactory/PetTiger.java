package com.company.designpatternsV2.abstractFactory;

public class PetTiger implements Tiger{
    @Override
    public void speak() {
        System.out.println("Pet Tiger says softly: Halum.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Pet tigers play in the animal circus.\n");
    }
}
