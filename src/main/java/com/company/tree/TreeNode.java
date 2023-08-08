package com.company.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class TreeNode<T> {
    T data;
    List<TreeNode<T>> children = new LinkedList<>();

    TreeNode(T data) {
        this.data = data;
    }

    TreeNode(T data, List<TreeNode<T>> children) {
        this.children = children;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.children.add(new TreeNode<>(2));
        root.children.add(new TreeNode<>(3));
        root.children.add(new TreeNode<>(4));
        root.children.get(0).children.add(new TreeNode<>(5));
        root.children.get(0).children.add(new TreeNode<>(6));
        root.children.get(0).children.add(new TreeNode<>(7));
        root.children.get(1).children.add(new TreeNode<>(8));
        root.children.get(2).children.add(new TreeNode<>(9));
        root.children.get(2).children.add(new TreeNode<>(10));
        root.children.get(2).children.add(new TreeNode<>(11));
        //printNAryTree(root);
    }

    private void printNAryTree(TreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode<T> node = queue.poll();
                System.out.println(node.data + " ");
                for (TreeNode<T> child : node.children) {
                    queue.offer(child);
                }
            }
            System.out.println();
        }

    }

}
