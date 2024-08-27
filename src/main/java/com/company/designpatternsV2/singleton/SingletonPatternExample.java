package com.company.designpatternsV2.singleton;

public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("Singleton pattern Demo");
        System.out.println("Trying to make a captain for your team");
        // Captain c3 = new Captain(); fails because constructor is private
        Captain captain1 = Captain.getCaptain();
        System.out.println("Trying to make another captain for your team");
        Captain captain2 = Captain.getCaptain();
        if (captain1 == captain2) {
            System.out.println("captain1 and captain2 are the same instance ");
        }
    }
}
