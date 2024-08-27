package com.company.designpatternsV2.abstractFactory;

public class WildDog implements Dog {
    @Override
    public void speak() {
        System.out.println("Wild dog says loudly: Bow-Wow");
    }

    @Override
    public void preferredAction() {
        System.out.println("Wild Dogs prefer to roam freely in Jungles\n");
    }
}
