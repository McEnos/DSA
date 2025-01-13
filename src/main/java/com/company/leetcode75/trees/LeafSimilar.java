package com.company.leetcode75.trees;

import com.company.leetcode.models.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75
 * https://leetcode.com/problems/leaf-similar-trees/solutions/4536195/simple-java-solution-beats-100
 */
public class LeafSimilar {
    public static void main(String[] args) {
    }

    private static boolean solution(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traversal(root1, list1);
        traversal(root2, list2);
        if (list1.size() != list2.size())
            return false;

        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static void traversal(TreeNode root, List<Integer> list) {
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) list.add(root.val);
        if (Objects.nonNull(root.left)) {
            traversal(root.left, list);
        }
        if (Objects.nonNull(root.right)) {
            traversal(root.right, list);
        }
    }
}
