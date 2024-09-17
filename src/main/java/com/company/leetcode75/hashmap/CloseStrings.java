package com.company.leetcode75.hashmap;

import java.util.*;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
 * https://chatgpt.com/share/66e8e689-a5f8-8011-89d4-576263f58f9b
 * <p>
 * Check if word1 and word2 have the same length. If not, return false.
 * Check if word1 and word2 contain the same characters. If not, return false.
 * Check if the character frequencies in both strings are the same (in any order). If not, return false.
 */
public class CloseStrings {
    public static void main(String[] args) {
        System.out.println(solution("abc", "bca"));
        System.out.println(solution("a", "aa"));
        System.out.println(solution("cabbba", "abbccc"));
    }

    private static boolean solution(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        //Frequency arrays for both strings
        /**
         * Each index in the array corresponds to a letter in the alphabet. For example:
         *         index 0 corresponds to 'a'
         *         index 1 corresponds to 'b'
         *         index 2 corresponds to 'c'
         *         and so on until index 25 which corresponds to 'z'.
         */

        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];

        /**
         *  Character Presence Array (to track which characters exist):
         *  If a character appears in the string, we mark true in the corresponding index of the array.
         */

        //Set of character in both strings
        boolean[] chars1 = new boolean[26];
        boolean[] chars2 = new boolean[26];

        for (char c : word1.toCharArray()) {
            frequency1[c - 'a']++;
            chars1[c - 'a'] = true;
        }

        for (char c : word2.toCharArray()) {
            frequency2[c - 'a']++;
            chars2[c - 'a'] = true;
        }
        // Check if both strings have the same set of characters
        if (!Arrays.equals(chars1, chars2)) return false;

        // Check if both strings have the same frequency counts (in any order)
        Arrays.sort(frequency1);
        Arrays.sort(frequency2);
        // Check if both strings have the same frequency counts (in any order)
        return Arrays.equals(frequency1, frequency2);

    }

    private boolean solutionV2(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        Set<Character> chars1 = new HashSet<>();
        Set<Character> chars2 = new HashSet<>();

        for (char c : word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
            chars1.add(c);
        }
        for (char c : word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
            chars2.add(c);
        }

        if (!chars1.equals(chars2)) return false;

        List<Integer> list1 = new ArrayList<>(freq1.values().stream().toList());
        List<Integer> list2 = new ArrayList<>(freq2.values().stream().toList());

        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }
}
