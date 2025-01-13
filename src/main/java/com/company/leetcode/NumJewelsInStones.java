package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumJewelsInStones {
    public static void main(String[] args) {

    }

    private static int solution(String jewels, String stones) {
        int count = 0;
        List<Character> jewelsList = new ArrayList<>();
        for (char c : jewels.toCharArray()) {
            jewelsList.add(c);
        }
        for (char c : stones.toCharArray()) {
            if (jewelsList.contains(c)) {
                count++;
            }
        }
        return count;
    }

    private static int solutionV2(String jewels, String stones) {
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (jewels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
