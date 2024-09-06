package com.company.leetcode75;

/**
 * https://leetcode.com/problems/can-place-flowers/solutions/5079899/easy-simple-java-solution-under-15-lines
 * <p>
 * Intuition
 * We are trying to check if every other position is capable of storing a flower until there are no more flowers left to store.
 * This can be done by checking every position, however I decided to check every other position to save some checks.
 * <p>
 * Case 1:
 * flowerbed[i] has a 0 and flowerbed[i+1] has a 0. This means a flower can be stored at i, so we decrease n (number of flowers left to store).
 * <p>
 * EDGE CASE: Suppose we have something like [1,0,0,0,1,0,0]. The last index can store a flower,
 * however it cannot check i+1 as that is out of bounds. So, we must check for the condition if flowerbed[i] is 0 and i==flowerbed.length-1.
 * This means that the last index can store a flower. We do not need to check the previous as our cases ensure that we are always at a position where a flower can be stored.
 * <p>
 * Case 2:
 * flowerbed[i] has 0 and flowerbed[i+1] has 1. This means that the flower cannot be stored here as there is one adjacent to it.
 * The next possible spot would be two after i+1. So, we want to i++.
 * <p>
 * Case 3:
 * flowerbed[i] has 1. This means the flower cannot be stored here. We continue with the iteration.
 * Finally, if n is less than or equal to 0, then we return true as there are enough positions to place all the flowers. Else, we return false.
 */
public class CanPlaceFlower {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(solution(new int[]{1, 0, 0, 0, 1}, 2));
    }

    private static boolean solution(int[] flowerBed, int n) {
        for (int i = 0; i <= flowerBed.length - 1; i += 1) {
            //this order of check matters*/
            if ((flowerBed[i] == 0 && i == flowerBed.length - 1) || (flowerBed[i] == 0 && flowerBed[i + 1] == 0)) {
                n--;
            } else if (flowerBed[i] == 0 && flowerBed[i + 1] == 1) {
                i++;
            }
        }
        return n <= 0;
    }
}
