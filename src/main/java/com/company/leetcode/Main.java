package com.company.leetcode;

import java.util.*;

public class Main {
    //https://github.com/Neelesh-Janga/Java-Programs/tree/main
    public static void main(String[] args) {
    }

    //https://leetcode.com/problems/ransom-note/
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineLetters = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char letter = magazine.charAt(i);
            int currentCount = magazineLetters.getOrDefault(letter, 0);
            magazineLetters.put(letter, currentCount + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char letter = ransomNote.charAt(i);
            int currentCount = magazineLetters.getOrDefault(letter, 0);
            if (currentCount == 0)
                return false;
            magazineLetters.put(letter, currentCount - 1);
        }
        return true;
    }

    //https://leetcode.com/problems/binary-search/
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }




    //https://leetcode.com/problems/concatenation-of-array/
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }

    //https://leetcode.com/problems/build-array-from-permutation/
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }


}
