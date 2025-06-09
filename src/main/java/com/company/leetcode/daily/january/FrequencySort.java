package com.company.leetcode.daily.january;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(solution("tree"));
    }

    private static String solution(String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue().compareTo(e1.getValue())
        ); // Max-Heap based on frequency
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(freq.entrySet());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> data = maxHeap.poll(); // Extract max frequency element
            char c = data.getKey();
            int characterFrequency = data.getValue();
            for(int i = 0; i < characterFrequency; i++){
                result.append(c); // Append the character freq times
            }
            //result.append(String.valueOf(data.getKey()).repeat(data.getValue()));
        }

        return result.toString();
    }

    private static String solutionV2(String s) {
        // Step 1: Count character frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        //Step 2: create buckets for frequency sorting
        List<Character>[] buckets = new List[s.length() + 1];

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }
        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}
