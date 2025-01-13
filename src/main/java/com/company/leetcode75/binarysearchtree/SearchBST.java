package com.company.leetcode75.binarysearchtree;

import com.company.leetcode.models.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/?envType=study-plan-v2&envId=leetcode-75
 * 700. Search in a Binary Search Tree
 */
public class SearchBST {
    public static void main(String[] args) {

    }

    private static TreeNode solution(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == val) {
                return current;
            }
            if (Objects.nonNull(current.left)) {
                queue.offer(current.left);
            }
            if (Objects.nonNull(current.right)) {
                queue.offer(current.right);
            }
        }
        return null;
    }
}
