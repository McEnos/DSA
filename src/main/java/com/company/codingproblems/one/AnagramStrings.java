package com.company.codingproblems.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramStrings {
    public static void main(String[] args) {
        System.out.println(solutionV2("listen","silent"));
        System.out.println(solution("listen","silent"));
    }

    private static boolean solution(String v1, String v2) {
        v1 = v1.replace("\\s", "").toLowerCase();
        v2 = v2.replace("\\s", "").toLowerCase();
        if (v1.length() != v2.length())
            return false;
        char[] v1CharArray = v1.toCharArray();
        char[] v2CharArray = v2.toCharArray();
        Arrays.sort(v2CharArray);
        Arrays.sort(v1CharArray);
        return Arrays.equals(v1CharArray, v2CharArray);
    }

    private static boolean solutionV2(String v1, String v2) {
        v1 = v1.toLowerCase().replace("\\s", "");
        v2 = v2.toLowerCase().replace("\\s", "");
        if (v1.length() != v2.length()) {
            return false;
        }
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : v1.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (char c : v2.toCharArray()) {
            if (!frequency.containsKey(c)) {
                return false;
            }
            frequency.put(c, frequency.get(c) - 1);
            if (frequency.get(c) == 0) {
                frequency.remove(c);
            }
        }
        return frequency.isEmpty();
    }


}
