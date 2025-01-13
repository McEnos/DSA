package com.company.hackerrank;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(solution("UDDDUDUU"));
    }

    private static int solution(String path) {
        int altitude = 0; // Start at sea level
        int valleys = 0;
        for (char c : path.toCharArray()) {
            int previousAltitude = altitude; // Track previous altitude before taking the step
            // Adjust altitude based on the step
            if (c == 'U') {
                altitude++;
            } else {
                altitude--;
            }
            // Check if we just came up to sea level from a valley
            if (previousAltitude < 0 && altitude == 0) {
                valleys++;
            }
        }
        return valleys;
    }
}
