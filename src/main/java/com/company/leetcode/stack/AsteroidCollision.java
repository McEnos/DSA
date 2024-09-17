package com.company.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75
 * https://leetcode.com/problems/asteroid-collision/solutions/3791318/explained-100-working-very-easy-to-understand
 * Stack Usage:
            We use a stack to store the right-moving asteroids (positive ones).
            Whenever a left-moving asteroid (negative) is encountered, we check for possible collisions with the top of the stack.
 Collision Logic:
                The main condition for a collision is that the stack has a positive asteroid (moving right) and the current asteroid is negative (moving left).
                If a collision occurs, we compare the magnitudes (absolute values) of the two asteroids to determine which one explodes.
 Possible Outcomes in Collisions:
                If the current asteroid is smaller than the top of the stack, it explodes (exploded = true), and we do nothing more.
                If the current asteroid is larger, the top asteroid in the stack explodes (so we pop it), and we continue to check the next top asteroid.
                If they are equal, both asteroids explode.
 Final Result:
                After processing all asteroids, the stack will contain the remaining asteroids that survived, and we convert the stack to an array for the final output.
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(solution(new int[]{8, -8})));
        System.out.println(Arrays.toString(solution(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(solution(new int[]{-2, -1, 1, 2})));
    }

    private static int[] solution(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean exploded = false;  // Indicates if the current asteroid has exploded
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                Integer top = stack.peek();
                if (Math.abs(asteroid) < top) {   // If the asteroid in the stack is bigger, the current asteroid explodes
                    exploded = true;
                    break;
                } else if (Math.abs(asteroid) == top) {  // If both are the same size, both explode
                    exploded = true;
                    stack.pop();  // Remove the top asteroid because it explodes too
                    break;
                } else {  // If the asteroid in the stack is smaller, the top asteroid explodes
                    stack.pop();  // The top asteroid explodes, but we continue checking
                }
            }
            if (!exploded) {  // If the current asteroid hasn't exploded, add it to the stack
                stack.push(asteroid);
            }

        }
        int[] state = new int[stack.size()];
        for (int i = state.length - 1; i >= 0; i--) {
            state[i] = stack.pop();
        }
        return state;
    }
}
