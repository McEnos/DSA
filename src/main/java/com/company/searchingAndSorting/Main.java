package com.company.searchingAndSorting;

public class Main {
    public static void main(String[] args) {

    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; //return the index where target is found;
            }
        }
        return -1; //Target not found;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0; // Initialize the left boundary of the search range
        int high = arr.length - 1; // Initialize the right boundary of the search range
        while (low <= high) { // Continue searching while the range is valid
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
             *
             * Using low + (high - low) / 2 instead of (low + high) / 2 prevents integer overflow by
             * ensuring that the intermediate sum does not exceed the maximum value an integer can hold.
             */
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

    /**
     * Bubble sort is a simple sorting algorithm that repeatedly steps through the list,
     * compares adjacent elements, and swaps them if they are in the wrong order.
     * The process is repeated until the list is sorted.
     *
     */
    //https://www.geeksforgeeks.org/bubble-sort/
    public static int[] bubbleSort(int[] arr) {

        int n = arr.length; //Determine the number of elements in the array.
        //Outer loop for multiple passes through the array
        //This loop runs n-1 times, representing the number of passes needed to ensure the array is sorted.
        //After each pass, the next largest element is correctly positioned at the end of the array.
        for (int i = 0; i < n - 1; i++) {
            //Inner loop for comparing adjacent elements
            //This loop iterates through the unsorted portion of the array.
            //The - i part ensures that the inner loop does not consider the already sorted elements at the end of the array.
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare and swap if they are in the wrong order
                //If the current element is greater than the next element, swap them.
                //This ensures that the larger element bubbles up to its correct position.
                if (arr[j] > arr[j + 1]) {
                    //Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    /**
     * this algorithm can be optimized by checking if a swap happened, if swap never happened, it means the list
     * is already sorted
     * i.e  It can be optimized by stopping the algorithm if the inner loop didn’t cause any swap.
     */
    public static int[] bubbleSortV1(int[] arr) {
        int n = arr.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    //https://www.geeksforgeeks.org/selection-sort/

    /**
     * Selection sort is a simple comparison-based sorting algorithm. It divides the input list into two parts:
     * the sublist of items already sorted, which is built up from left to right,
     * and the sublist of items remaining to be sorted that occupy the rest of the list.
     * Initially, the sorted sublist is empty, and the unsorted sublist is the entire input list.
     * The algorithm proceeds by finding the smallest element in the unsorted sublist,
     * exchanging it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.
     *
     */
    public static int[] selectionSort(int[] arr) {
        int n = arr.length; // Get the length of the array
        //One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) { // Outer loop to place the correct element at index i
            // Find the minimum element in the unsorted array
            int minimumIndex = i; // Assume the current index is the minimum
            // Inner loop to find the true minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) { // Traverse the unsorted subarray
                if (arr[j] < arr[minimumIndex]) { // If the current element is smaller, update minIdx
                    minimumIndex = j; // Update minimumIndex if a smaller element is found
                }
            }
            // Swap the found minimum element with the element at index i
            // Swap the found minimum element with the first element of the unsorted subarray
            int temp = arr[minimumIndex]; // Temporary storage for the smallest element
            arr[minimumIndex] = arr[i]; // Put the current element in the place of the smallest
            arr[i] = temp; // Put the smallest element in its correct place
        }
        return arr;
    }

    //https://www.geeksforgeeks.org/insertion-sort/

    /**
     * Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time
     * Insertion sort is an efficient algorithm for small datasets or nearly sorted arrays,
     * with a time complexity of O(n^2) in the worst case. It works by building the final sorted array one item at a time,
     * inserting each item into its proper place within the sorted portion of the array.
     *
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        int n = arr.length; // Get the length of the array
        // Start with the second element (index 1) since the first element is trivially sorted
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Store the current element to be inserted
            int j = i - 1; // Initialize j to point to the element before i
            // Shift elements of arr[0..i-1], that are greater than key, to one position ahead
            // of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift element to the right
                j--; // Move to the previous element
            }
            arr[j + 1] = key; // Insert the key at the correct position
        }
        return arr;
    }

    //https://www.geeksforgeeks.org/merge-sort/
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // Check if the array contains more than one element
            int mid = (left + right) / 2; // Find the middle point
            // Recursively sort the first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);  // Merge the sorted halves
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;   // Find sizes of two sub-arrays to be merged
        int n2 = right - mid;

        //Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //Copy data to temporary arrays
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        //Merge the temporary arrays
        //Initial indices of the first and second sub-array
        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //Copy the remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        //Copy the remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
