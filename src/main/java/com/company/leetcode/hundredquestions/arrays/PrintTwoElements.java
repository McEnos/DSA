package com.company.leetcode.hundredquestions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintTwoElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 1, 2, 5, 3})));
    }

    private static int[] solutionV5(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> frequency = new HashMap<>();
        int missing = -1;
        int repeating = -1;
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            if (!frequency.containsKey(i)) {
                missing = i;
            }
            if (frequency.get(missing) > 1) {
                repeating = i;
            }
        }
        return new int[]{missing, repeating};
    }

    private static int[] solution(int[] nums) {
        int n = nums.length;
        //This is because the array nums contains numbers ranging from 1 to n,
        // but one number is missing, and another number is repeated.
        boolean[] visited = new boolean[n + 1];
        int repeating = -1;
        int missing = -1;
        // First pass: Mark numbers as visited and find the repeating number
        for (int num : nums) {
            if (!visited[num]) {
                visited[num] = true; // mark the number as visited
            } else {
                repeating = num; // if visited already, it's the repeating number
            }
        }
        // Second pass: Find the missing number
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                missing = i;  // the number that is not visited is the missing number
                break;
            }
        }
        return new int[]{repeating, missing};
    }

    private static int[] solutionV3(int[] nums) {
        int n = nums.length;
        // Step 1: Sort the array
        Arrays.sort(nums);
        int repeating = -1;
        int missing = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if two consecutive elements are the same (repeating number)
            if (nums[i] == nums[i + 1]) {
                repeating = nums[i];
            }
            if (nums[i + 1] != nums[i] + 1 && nums[i + 1] != nums[i]) {
                missing = nums[i] + 1;
            }
        }
        if (nums[n - 1] != n) {
            missing = n;
        }
        return new int[]{repeating, missing};


    }

    private static int[] solutionV4(int[] nums) {
        int n = nums.length;
        long sumN = (n * (n + 1)) / 2;
        long sumSqN = (n * (n + 1) * (2 * n + 1)) / 6;

        // Step 2: Calculate the actual sum and sum of squares

        long sum = 0;
        long sumSq = 0;
        for (int num : nums) {
            sum += num;
            sumSq += (long) num * num;
        }
        // Step 3: Calculate differences
        long diffSum = sum - sumN;
        long diffSumSq = sumSq - sumSqN;

        // Step 4: Solve for y and x
        long sumXplusY = diffSumSq / diffSum;
        long y = (diffSum + sumXplusY) / 2;
        long x = sumXplusY - y;
        return new int[]{(int) x, (int) y};
    }

    /**
     * Using XOR
     * XOR Properties:
     * 1) Self-Cancellation: a ⊕ a = 0 (XOR-ing a number with itself results in 0).
     * 2) Identity: a ⊕ 0 = a (XOR-ing a number with 0 results in the number itself).
     * 3) Commutativity and Associativity: The order in which numbers are XOR-ed doesn't matter.
     * Using these properties, we can XOR all the numbers from the array and from the range 1 to n.
     * This cancels out the numbers that appear once, leaving us with the XOR of the missing number and the repeating number.
     * <p>
     * XOR all the elements in the array. Let this result be called XOR1.
     * XOR all the numbers from 1 to n. Let this result be called XOR2.
     */
    private static int[] solution2(int[] nums) {
        return new int[]{};
    }

}
