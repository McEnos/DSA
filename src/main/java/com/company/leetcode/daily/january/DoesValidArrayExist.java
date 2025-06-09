package com.company.leetcode.daily.january;

/**
 * https://leetcode.com/problems/neighboring-bitwise-xor
 */
public class DoesValidArrayExist {
    public static void main(String[] args){

    }

    private static boolean solution(int[] derived){
        int sum = 0;
        for(int num: derived){
            sum += num;
        }
        return sum % 2 == 0;
    }
}
