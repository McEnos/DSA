package com.company.designpatterns.creational.builder;

public class Main {
    public static void main(String[] args){
        Post post = new Post.Builder()
                .title("Java Builder Pattern")
                .text("Explaining how to implement the Builder Pattern in Java")
                .category("Programming")
                .build();
        System.out.println(post);
    }
}
