package com.company.leetcode75.trees;

import com.company.leetcode.models.TreeNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * https://leetcode.com/problems/diameter-of-binary-tree/solutions/4446094/best-java-solution-beats-100
 * The diameter of a binary tree is the length of the longest path between any two nodes in the tree.
 * The path may or may not pass through the root, and the length is measured in terms of the number of edges between nodes.
 * diameter_through_node = height_of_left_subtree + height_of_right_subtree
 * We can calculate the diameter by recursively computing the height of the left and right subtrees
 * for every node and then keeping track of the maximum diameter found during this traversal.
 * <p>
 * Height Calculation: The height of a node is the maximum depth between its left and right subtrees.
 * Update Diameter: For every node, calculate the diameter through it and update the overall diameter if it’s the largest found so far.
 */
public class DiameterOfBinaryTree {
    static int max;

    public static void main(String[] args) {

    }

    private static int solution(TreeNode root) {
        max = 0;
        height(root);
        return max;
    }

    private static int height(TreeNode root) {
        if (Objects.isNull(root)) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        max = Math.max(leftHeight + rightHeight, max);
        return 1 + Math.max(leftHeight, rightHeight);
    }


}
