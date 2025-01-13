package com.company.searchingAndSorting;

public class BinarySearch {
    public static void main(String[] args) {

        int a = 128;
        int b = 128;
        System.out.println(a == b);
    }

    /**
     * In some programming languages, including Java, integer overflow can occur when dealing with large numbers.
     * When calculating the midpoint in a binary search, a common formula is (low + high) / 2.
     * However, if low and high are large enough, their sum could exceed the maximum value an integer can store, causing overflow.
     * Java uses 32-bit signed integers, which have a maximum value of 2,147,483,647 (Integer.MAX_VALUE).
     * If low and high are both close to this maximum value, their sum could wrap around to a negative number due to overflow. For example:
     * int low = 2_000_000_000;
     * int high = 2_000_000_000;
     * int mid = (low + high) / 2; This will overflow and produce a negative result
     * To prevent overflow, the midpoint is calculated using the formula low + (high - low) / 2 instead of (low + high) / 2.
     * This approach ensures that we are only adding a value that cannot cause overflow:
     * <p>
     * <p>
     * Using low + (high - low) / 2 instead of (low + high) / 2 prevents integer overflow by
     * ensuring that the intermediate sum does not exceed the maximum value an integer can hold.
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0; // Initialize the left boundary of the search range
        int high = arr.length - 1; // Initialize the right boundary of the search range
        while (low <= high) { // Continue searching while the range is valid

            int mid = low + (high - low) / 2; // Calculate the middle index to avoid overflow
            if (arr[mid] == target) { // Check if the middle element is the target
                return mid; // If it is, return the index of the middle element
            }
            if (arr[mid] < target) { // If the target is greater than the middle element
                low = mid + 1; // Move the left boundary to the right of the middle index
            } else { // If the target is less than the middle element
                high = mid - 1; // Move the right boundary to the left of the middle index
            }

        }
        return -1; // Return -1 if the target is not found
    }
}
