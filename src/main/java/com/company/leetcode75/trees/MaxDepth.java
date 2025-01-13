package com.company.leetcode75.trees;

import com.company.leetcode.models.TreeNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/solutions/5532439/beats-100-easy-java-solution
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    private static int solution(TreeNode root) {
        if (Objects.isNull(root)) return 0;
        int left = solution(root.left);
        int right = solution(root.right);

        return Math.max(left, right) + 1;
    }
}
