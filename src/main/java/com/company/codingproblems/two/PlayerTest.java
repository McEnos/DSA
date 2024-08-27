package com.company.codingproblems.two;

public class PlayerTest {
    public static void main(String[] args) {
        Player p1 = new Player(1, "Rafael Nadal");
        Player p2 = new Player(1, "Rafael Nadal");
        System.out.println(p1.equals(p2));
        System.out.println("p1 hash code: "+ p1.hashCode());
        System.out.println("p2 hash code: "+ p2.hashCode());
    }
}
