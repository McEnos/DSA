package com.company.leetcode75.twopointers;

//https://leetcode.com/problems/sum-of-square-numbers/?envType=problem-list-v2&envId=two-pointers&
public class JudgeSquareSum {
    public static void main(String[] args) {
     //   System.out.println(solution(5));
        System.out.println(solution(2147483600));
    }

    private static boolean solution(int c) {
        long lowest = 0;
        long highest = (long) Math.sqrt(c);
        while (lowest <= highest) {
            long squareSum = lowest * lowest + highest * highest;
            if (squareSum == c) {
                return true;
            }
            if (squareSum < c) {
                lowest++;
            } else {
                highest--;
            }
        }
        return false;
    }
}
