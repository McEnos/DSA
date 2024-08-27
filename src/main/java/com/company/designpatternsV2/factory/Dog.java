package com.company.designpatternsV2.factory;

public class Dog implements Animal{
    @Override
    public void speak() {
        System.out.println("Dog says: Bow-Wow");
    }

    @Override
    public void preferredAction() {
        System.out.println("Dogs prefer barking...\n");
    }
}
