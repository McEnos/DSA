package com.company.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,0,0},34));
        System.out.println(solution(new int[]{2,7,4},181));
        System.out.println(solution(new int[]{2,1,5},806));
    }

    private static List<Integer> solution(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i);
        }
        int resultingAddition = Integer.parseInt(sb.toString()) + k;
        for (char c : String.valueOf(resultingAddition).toCharArray()) {
            result.add(Integer.parseInt(String.valueOf(c)));
        }
        return result;
    }
}
