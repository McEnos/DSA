package com.company.leetcode75.binarysearchtree;

import com.company.leetcode.models.TreeNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/?envType=study-plan-v2&envId=leetcode-75
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/solutions/4861091/delete-a-node-in-bst-easytounderstand
 *
 * https://chatgpt.com/share/67035232-c12c-8011-9ab6-3c067def3c34
 */
public class DeleteNode {
    public static void main(String[] args) {
    }

    private static TreeNode solution(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return null;
        }
        // Traverse the tree to find the node to be deleted
        if (key < root.val) {
            root.left = solution(root.left, key);
        } else if (key > root.val) {
            root.right = solution(root.right, key);
        } else {
            // Node found, handle the three cases:
            // Case 1---> when root is present only
            if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
                return null;
            }
            // Case 2---> 1 Children in left or right
            if (Objects.isNull(root.left)) {
                return root.right;
            }
            if (Objects.isNull(root.right)) {
                return root.left;
            }
            // Case-3---> 2 Children
            TreeNode successor = findInOrderSuccessor(root.right);
            root.val = successor.val;  // Replace root's value with the successor's value
            root.right = solution(root.right, successor.val); // Delete the successor


        }
        return root;
    }

    /**
     * Find the minimum
     */
    private static TreeNode findInOrderSuccessor(TreeNode root) {
        // The in-order successor is the leftmost node in the right subtree
        while (Objects.nonNull(root.left)) {
            root = root.left;
        }
        return root;
    }

}
