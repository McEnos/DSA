package com.company.linkedlist;

public class Stack<T> {
    private LinkedList<T> linkedList;

    public void push(T data){
        linkedList.insertAtBeginning(data);
    }
    public void pop(){
        linkedList.deleteFirstNode();
    }

    public Node<T> peek(){
        return linkedList.head;
    }
}
