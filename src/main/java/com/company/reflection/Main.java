package com.company.reflection;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Bird bird = new Bird("Parrot",2);
        Class<Bird> birdClass = Bird.class;
        System.out.println(birdClass);
        int modifiers = birdClass.getModifiers();
        Method[] methods = birdClass.getMethods();
        System.out.println(methods);
        System.out.println(modifiers);
    }
}
