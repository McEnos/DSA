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


        root.leftChild = second;
        root.rightChild = third;

        second.leftChild = fourth;
        second.rightChild = fifth;

        third.leftChild = sixth;
        third.rightChild = seventh;

        BinaryTree<Integer> tree = new BinaryTree<>(root);
        //tree.postorder(root);
        System.out.print("Recursive Preorder: ");
        tree.preorder(root);
        System.out.println();
        System.out.println("Iterative PreOrder "+ tree.iterativePreOrder(root));
        System.out.println();
        System.out.print("Recursive Inorder: ");
        tree.inorder(root);
        System.out.println();
        System.out.println("Iterative Inorder: " + tree.iterativeInOrder(root));
        ;
        System.out.println();
        System.out.println("Iterative PostOrder" + tree.iterativePostorder(root));
        System.out.print("Recursive PostOrder: ");
        tree.postorder(root);
        System.out.println();
        System.out.println("LevelOrder" + tree.levelOrder(root));


    }
}
