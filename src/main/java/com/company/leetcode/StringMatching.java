package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/string-matching-in-an-array
 */
public class StringMatching {
    public static void main(String[] args) {

    }

    private static List<String> solution(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
