package com.company.tree;

public class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> leftChild;
    BinaryTreeNode<T> rightChild;


    public BinaryTreeNode(T data) {
        this.data = data;
        this.leftChild = this.rightChild = null;
    }


}
