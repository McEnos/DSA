package com.company.leetcode;

import com.company.leetcode.models.ListNode;
import com.company.leetcode.models.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 102. Binary Tree Level Order Traversal
 */
public class LevelOrder {
    public static void main(String[] args) {
        ConcurrentSkipListSet set = new ConcurrentSkipListSet();
    }

    private List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
