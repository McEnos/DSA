package com.company.leetcode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println(balancedParentheses("[{{}}[]()]"));
        System.out.println( findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
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

    public static boolean balancedParentheses(String value) {
        Stack<Character> stack = new Stack<>();
        for (char c : value.toCharArray()) {
            if (Arrays.asList('(', '{', '[').contains(c)) {
                stack.add(c);
            } else if (stack.isEmpty() && Arrays.asList(']', ')', '}').contains(c)) {
                return false;
            } else {
                char topCharacter = stack.pop();
                if (!corresponding(topCharacter, c))
                    return false;

            }
        }
        return stack.isEmpty();
    }

    public static boolean corresponding(char opening, char closing) {
        return Objects.equals(opening, '{') && Objects.equals(closing, '}') ||
                Objects.equals(opening, '[') && Objects.equals(closing, ']') ||
                Objects.equals(opening, '(') && Objects.equals(closing, ')');
    }

    public static double findMaxAverage(int[] nums, int k){
        double max = Integer.MIN_VALUE;
        for (int i =0; i < nums.length; i++){
            double windowSum = 0;
            for(int j=0;j<k;j++){
                if (!(i+(k-1) > nums.length-1)){
                    windowSum += nums[i+j];
                }else{
                    i = nums.length;
                    j = k;
                }
            }
            if (windowSum != 0){
                max = Math.max(max,windowSum/k);
            }
        }
        if (max == Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
}
