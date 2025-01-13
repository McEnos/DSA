package com.company.trees;

/**
 * https://chatgpt.com/c/66df1ebc-3a54-8011-a7a9-97571cea4473
 */
public class Main {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> first = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> second = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> third = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> fourth = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> fifth = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> sixth = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> seventh = new BinaryTreeNode<>(7);

        first.leftChild = second;
        first.rightChild = third;

        second.leftChild = fourth;
        second.rightChild = fifth;

        third.leftChild = sixth;
        third.rightChild = seventh;

        BinaryTree<Integer> tree = new BinaryTree<>(first);

        System.out.println("Pre order traversal :");
        tree.preOrder(first);
        System.out.println();
        System.out.println(tree.iterativePreOrder(first));
        System.out.println("Inorder traversal :");
        tree.inOrder(first);
        System.out.println();
        System.out.println(tree.iterativeInorder(first));
        System.out.println("Post order traversal :");
        tree.postOrder(first);
        System.out.println();
        System.out.println(tree.iterativePostOrder(first));
        System.out.println("Level order traversal");
        System.out.println(tree.levelOrder(first));
        System.out.println();
        System.out.println(tree.maximumValueLevelOrder(first));

    }
}
