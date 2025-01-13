package com.company.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/missing-number/
 * 268 Missing Number
 * Time: O(n) (two loops through the array)
 * Space: O(1) (no extra space used)
 *
 * properties of XOR used in this problem
 * XOR of a number with itself is 0:
 *  a⊕a=0
 *      When the same number appears twice in an XOR operation, it cancels itself out.
 *      Example:
 *          In our case, every number that is present in both the full range [0, n] and the array will cancel out when XORed.
 *          For example: The number 3 appears both in the range and the array, so: 3⊕3=0
 * XOR of a number with 0 is the number itself:
 *  a⊕0=a
 *      If we XOR a number with 0, the result is the number itself. Example: 2⊕0=2
 *      How We Used It: We initialize the XOR accumulator to 0. As we XOR through all numbers,
 *      the missing number (which doesn’t have a pair) won’t be canceled out and will remain in the final result.
 * XOR is commutative and associative:
 *      a⊕b⊕c=c⊕a⊕b
 *      The order in which we perform XOR operations doesn’t matter.
 *      How We Used It:
 *          We first XOR all numbers in the range [0, n] and then XOR the elements in the array.
 *          Since XOR is commutative and associative, we can rearrange the operations freely, ensuring
 *          that all matching numbers cancel out regardless of order.
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,0,1}));
        System.out.println(solution(new int[]{0,1}));
    }

    private static int solution(int[] nums) {
        int n = nums.length;
        int xor = 0;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        // XOR with all elements in the array
        for (int num : nums) {
            xor ^= num;
        }
        // The remaining value is the missing number
        return xor;
    }

}
