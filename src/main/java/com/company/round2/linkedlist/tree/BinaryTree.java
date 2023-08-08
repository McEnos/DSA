package com.company.round2.linkedlist.tree;

import java.util.*;

public class BinaryTree<T> {
    BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public void preOrder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        System.out.println(root.data + ", ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public void inOrder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        inOrder(root.leftChild);
        System.out.println(root.data + ", ");
        inOrder(root.leftChild);
    }

    public void postOrder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root.data + ", ");
    }

    public List<T> levelOrderTraversal(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> currentNode = queue.poll();
            result.add(currentNode.data);
            if (Objects.nonNull(currentNode.leftChild))
                queue.add(currentNode.leftChild);
            if (Objects.nonNull(currentNode.rightChild))
                queue.add(currentNode.rightChild);
        }
        return result;
    }
}
