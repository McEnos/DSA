package com.company.leetcode75.binarysearchtree;

import com.company.leetcode.models.TreeNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * 701. Insert into a Binary Search Tree
 */
public class InsertIntoBST {
    public static void main(String[] args) {

    }

    private TreeNode solution(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (Objects.isNull(root)) {
            root = node;
        } else {
            if (val < root.val) {
                root.left = solution(root.left, val);
            } else {
                root.right = solution(root.right, val);
            }
        }
        return root;
    }
}
