package com.company.leetcode.priorityqueue;


import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 347. Top K Frequent Elements
 * https://algo.monster/liteproblems/347
 */
public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    private static int[] solution(int[] nums, int k) {

        // Create a Map to store the frequency of each number
        Map<Integer, Integer> frequency = new HashMap<>();
        // Initialize a min-heap based on the frequency values
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        // Iterate over the frequency map
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            // Insert the current entry into the min-heap
            minHeap.offer(entry);
            // If the heap size exceeds 'k', remove the smallest frequency element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // Extract the top 'k' frequent numbers from the min-heap into an array
        return minHeap.stream()
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }



    /**
     *     // uses bucket sort
     * https://www.youtube.com/watch?v=EBNPu0GgM64
     *
     *
     */
    private static int[] solutionV2(int[] nums, int k) {
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

        }
        for (int key : frequency.keySet()) {
            int value = frequency.get(key);
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        }

        int[] result = new int[k];
        int counter = 0;
        for (int pos = buckets.length - 1; pos >= 0 && counter < k; pos--) {
            if (buckets[pos] != null) {
                for (Integer value : buckets[pos]) {
                    result[counter++] = value;

                }
            }
        }
        return result;

    }
}
