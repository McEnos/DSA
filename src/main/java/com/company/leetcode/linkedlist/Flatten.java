package com.company.leetcode.linkedlist;

import com.company.leetcode.models.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 114 Flatten Binary Tree to LinkedList
 */
public class Flatten {
    public static void main(String[] args) {

    }

    private static TreeNode flatten(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            return node;
        }
        // Recursively flatten the left and right subtrees
        TreeNode leftTail = flatten(node.left); // Tail of the left flattened subtree
        TreeNode rightTail = flatten(node.right); // Tail of the right flattened subtree
        // If there is a left subtree, move it to the right
        if (leftTail != null) {
            leftTail.right = node.right;  // Connect the end of the left subtree to the right subtree
            node.right = node.left;  // Move the left subtree to the right side of the node
            node.left = null;  // Set the left child to null
        }
        return rightTail == null ? leftTail : rightTail;  // Return the tail of the flattened subtree
    }

    private static void solution(TreeNode root) {
        flatten(root);
    }
}
