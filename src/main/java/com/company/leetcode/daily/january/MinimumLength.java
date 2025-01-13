package com.company.leetcode.daily.january;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-length-of-string-after-operations
 */
public class MinimumLength {
    public static void main(String[] args) {

    }

    private static int solution(String s) {
        // Step 1: Count the frequency of each character in the string
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        // Step 2: Calculate the number of characters to delete
        int deleteCount = 0;
        for (int frequency : freq.values()) {
            if (frequency % 2 == 1) {
                // If frequency is odd, delete all except one
                deleteCount += frequency - 1;
            } else {
                // If frequency is even, delete all except two
                deleteCount += frequency - 2;
            }
        }
        // Step 3: Return the minimum length after deletions
        return s.length() - deleteCount;

    }

    /**
     * In the previous approach, we used a hash map to count how often each character appears in the string.
     * Hash maps are flexible and can handle cases where the characters are not limited to a specific set.
     * However, they come with some downsides.
     * <p>
     * A hash map uses a dynamic data structure, which requires extra memory to store keys and values.
     * This leads to higher space usage compared to an array. Additionally,
     * the process of hashing (calculating a unique code for each character) takes time.
     * While hash map operations like insertion and lookup are generally fast (on average, they take O(1) time),
     * they can sometimes be slower due to hashing collisions (when two keys produce the same hash) and memory allocation.
     * <p>
     * In this problem, we only need to deal with lowercase English letters ('a' to 'z').
     * Since there are only 26 possible characters, we can use a fixed-size array of size 26 to count character frequencies.
     * <p>
     * To achieve this, we use a simple hashing operation to map each character to a position in a frequency array.
     * In ASCII, each lowercase letter can be represented as the value of 'a' plus its index in the alphabet.
     * By subtracting the ASCII value of 'a' from any character, we get a unique integer between 0 and 25,
     * which corresponds to its position in the frequency array.
     * <p>
     * This approach is more efficient for this specific case because of two reasons.
     * <p>
     * Better Runtime: When we access an element in an array, it’s always a constant time operation.
     * On the other hand, hash maps are O(1) on average,
     * but they can occasionally slow down because of the hashing process or when collisions happen.
     * Space Efficiency: An array of size 26 uses a fixed, small chunk of memory.
     * Unlike hash maps, arrays don’t need additional structures like hash buckets or key-value pairs, so they’re much more memory-efficient.
     */

    private static int solutionV2(String s) {
        // Step 1: Initialize a frequency array to count occurrences of each character
        int[] freq = new int[26];
        int totalLength = 0;
        // Step 2: Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        // Step 3: Calculate the total length after deletions count
        for (int frequency : freq) {
            if (frequency == 0) continue;  // Skip characters that don't appear
            if (frequency % 2 == 0) {
                totalLength += 2;  // If frequency is even, add 2 characters
            } else {
                totalLength += 1;
            }
        }
        // Step 4: Return the minimum length after deletions count
        return totalLength;
    }


}
