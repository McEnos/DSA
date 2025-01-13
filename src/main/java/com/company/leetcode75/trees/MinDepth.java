package com.company.leetcode75.trees;

import com.company.leetcode.models.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/solutions/5775222/simple-4-line-java-solution
 */
public class MinDepth {
    public static void main(String[] args) {

    }

    private static int solution(TreeNode root) {
        if (root == null) return 0;
        int left = solution(root.left);
        int right = solution(root.right);
        /**
         *  If a node has only one child, you must consider the depth of the non-null child, as a path must reach a leaf node.
         */
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
