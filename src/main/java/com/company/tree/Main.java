package com.company.tree;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> second = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> third = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> fourth = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> fifth = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> sixth = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> seventh = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> eighth = new BinaryTreeNode<>(8);
        root.leftChild = second;
        root.rightChild = third;
        second.leftChild = fourth;
        third.leftChild = fifth;
        third.rightChild = sixth;
        fifth.leftChild = seventh;
        fifth.rightChild = eighth;

        BinaryTree<Integer> tree = new BinaryTree<>(root);
        tree.postorder(root);
        System.out.println();
        System.out.println(tree.iterativePostorder(root));
        System.out.println();
        tree.preorder(root);
        System.out.println();
        System.out.println(tree.iterativePreorder(root));

        System.out.println();
        tree.inorder(root);
        System.out.println();
        //System.out.println(tree.iterativeInorder(root));
        //System.out.println();
        System.out.println(tree.iterativeInorder(root));
        System.out.println(tree.levelOrder(root));


    }
}
