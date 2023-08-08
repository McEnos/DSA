package com.company;

import com.company.linkedlist.Node;
import com.company.stack.ArrayStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class Main {

    public static void main(String[] args) throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("Joshua");
        stack.isEmpty();
        stack.size();
        Deque<String> deque = new ArrayDeque<>();
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("Joshua");
        arrayStack.push("Enos");
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack);


       /* var counter = new AtomicInteger();
        while (true){
            new Thread(() ->{
                int count = counter.incrementAndGet();
                System.out.println("Thread count = "+ count);
                LockSupport.park();
            }).start();*/
       // }
      /*  //System.out.println(factorial(5));

        Node<Integer> head = new Node<>(10);
        Node<Integer> second = new Node<>(11);
        Node<Integer> third = new Node<>(12);
        Node<Integer> fourth = new Node<>(13);
        Node<Integer> fifth = new Node<>(14);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);

        Node<Integer> currentNode = head;
        while (Objects.nonNull(currentNode)){
            currentNode = currentNode.getNext();
        }
        System.out.println(currentNode);
        Node<Integer> current = head;
        while (Objects.nonNull(current.getNext())){
            current = current.getNext();
        }
        System.out.println(current.getValue());*/
    }

    private static int factorial(int n){
        return n < 2 ? 1 : n * factorial(n - 1);
    }
}
