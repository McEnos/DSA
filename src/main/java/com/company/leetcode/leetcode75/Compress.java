package com.company.leetcode.leetcode75;

/**
 * https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/443
 */
public class Compress {
    public static void main(String[] args) {
        System.out.println(solution(new char[]{'a','a','b','b','c','c','c'}));
    }

    private static int solution(char[] chars) {
        int indexToWrite = 0;// tracks where to write in the array
        int length = chars.length; // total length of the input array
        // start processing each sequence of characters
        for (int start = 0; start < length; ) {
            // 'start' is the beginning of a sequence; 'end' will be one past the last char
            int end = start + 1;
            // expand the sequence to include all identical contiguous characters
            while (end < length && chars[end] == chars[start]) {
                end++;
            }
            // write the character that the sequence consists of
            chars[indexToWrite++] = chars[start];
            // if the sequence is longer than 1, write the count of characters
            if (end - start > 1) {
                String count = String.valueOf(end - start);  // convert count to string
                for (char c : count.toCharArray()) { // iterate over each character in the count
                    chars[indexToWrite++] = c;  // write count characters to the result array
                }
            }
            // move to the next sequence
            start = end;

        }
        // writeIndex represents the length of the compressed string within the array
        return indexToWrite;
    }
}
