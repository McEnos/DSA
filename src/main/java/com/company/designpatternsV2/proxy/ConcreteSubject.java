package com.company.designpatternsV2.proxy;

public class ConcreteSubject extends Subject{
    @Override
    public void doSomeWork() {
        System.out.println("doSomeWork() inside ConcreteSubject is invoked.");
    }
}
