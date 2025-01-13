package com.company.leetcode.leetcode75.prefixsum;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class LargestAltitude {
    public static void main(String[] args) {

    }

    private static int solution(int[] gain) {
        int maxAltitude = 0;  // Variable to store the highest altitude reached
        int currentAltitude = 0; // Variable to track the current altitude

        // Loop through all the altitude gains
        for (int altitudeGain  : gain) {
            // Update the current altitude by adding the altitude gain
            currentAltitude += altitudeGain;
            maxAltitude = Math.max(currentAltitude, maxAltitude);
        }
        return maxAltitude;
    }
}
