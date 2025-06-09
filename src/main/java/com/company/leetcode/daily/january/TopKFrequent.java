package com.company.leetcode.daily.january;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words
 */
public class TopKFrequent {
    public static void main(String[] args) {

    }

    private static List<String> solution(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        // Step 1: Count word frequencies
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        // Step 2: Use a min-heap (priority queue) to keep top k frequent words
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (e1, e2) -> Objects.equals(e1.getValue(), e2.getValue())
                        ? e2.getKey().compareTo(e1.getKey())  // Sort lexicographically descending for ties
                        : e1.getValue().compareTo(e2.getValue()) // Sort by frequency ascending
        );

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent or lexicographically larger word
            }
        }
        // Step 3: Extract words from heap into a result list
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        //Reverse the list to get correct order(most frequent first)
        Collections.reverse(result);

        return result;

    }
}
