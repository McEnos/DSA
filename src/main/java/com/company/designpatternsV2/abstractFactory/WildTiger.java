package com.company.designpatternsV2.abstractFactory;

public class WildTiger implements Tiger {
    @Override
    public void speak() {
        System.out.println("Wild Tiger says loudly: Halum.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Wild Tigers hunting in Jungles.\n");
    }
}
