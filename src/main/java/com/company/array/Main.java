package com.company.array;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[10];
        int length = 0;
        for (int i = 0; i < 6; i++) {
            //The length++ operation is a post-increment operation.
            //The value of length is used first to index into the array, and then length is incremented by 1.
            //This means that the current value of length is used for the array assignment, and immediately after, length is increased by 1.
            array[length++] = i;
            // length++;
        }
        length--;
        for (int i = 0; i < length; i++) {
            System.out.println("Index " + i + " contains " + array[i]);
        }


        int[] numbers = {1, 4, 5, 3, 7, 6, 8, 9};
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        for (String car : cars) {
            System.out.println(car);
        }

        String[] names = new String[5];

        String[] favourites = {};
        String[] favourites1 = new String[5];


        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        int[] squareNumbers = new int[10];
        for (int i = 0; i < 10; i++) {
            int square = (i + 1) * (i + 1);
            squareNumbers[i] = square;
        }
        System.out.println("Array operations: ");
        arrayOperations();

    }


    public static int[] insertBeginning(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = value;
        return arr;
    }

    public static int[] insertAtIndex(int[] arr, int index, int value) {
        // First,  create space for the new element.
        for (int i = arr.length - 1; i >= index; i--) {
            // Shift each element one position to the right.
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
        return arr;
    }

    public static int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int square = nums[i] * nums[i];
            squares[i] = square;
        }
        Arrays.sort(squares);
        return squares;
    }

    private int getNumberOfDigits(int number) {
        number = Math.abs(number); // Make sure the number is positive (remove the negative sign if exists
        int count = 0;
        while (number > 0) { //The loop continues to run as long as num is greater than zero. This means the loop will stop once num becomes zero.
            /**
             * This line divides num by 10 and assigns the result back to num.
             *  In integer division, dividing by 10 effectively removes the last digit of the number. For example:
             *  If num is 123, after num / 10, it becomes 12.
             *  If num is 12, after num / 10, it becomes 1.
             *  If num is 1, after num / 10, it becomes 0.
             *  The while loop iteratively removes the last digit of the number and increments the count until the number becomes zero.
             *  This effectively counts the total number of digits in the original number.
             */
            number = number / 10;
            count++;
        }
        return count;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;    // Variable to store the maximum consecutive 1s
        int count = 0;  // Variable to keep track of the current consecutive 1s count

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                count = 0;  // Reset the count if the current element is not 1
            }

            if (count > max) {
                max = count;  // Update the max if the current count is greater
            }
        }
        //[1,1,0,1,1,1]


        return max;  // Return the maximum consecutive 1s
    }



    //https://www.youtube.com/watch?v=C4oBXLr3zos&t=11s
    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;//to enable iterating through nums1 i.e length is m
        int p2 = n - 1; //to enable iterating through nums2 i.e length is n
        int i = m + n - 1; //to enable iterating through resulting array i.e length is n
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }

    }

    //https://leetcode.com/problems/remove-element/description/
    //https://youtu.be/pGKDzt0gk-A
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i : nums) {
            if (i != val) {
                nums[index++] = i;
            }
        }
        return index;
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                queue.add(0);
                queue.add(0);
            } else {
                queue.add(0);
            }
            Integer first = queue.poll();
            arr[i] = first;
        }
    }

    public static int fibRecursive(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibIterative(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 1; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int fibMemoized(int n) {
        int[] array = new int[n];
        array[1] = 1;
        array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[n - 1] + array[n - 2];
        }
        return array[n];
    }

    public static void arrayOperations() {
        Scanner scanner = new Scanner(System.in);
        int actualSize = 0;
        System.out.print("What is the array size: ");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        System.out.println("Array size > " + arraySize);
        for (int i = 0; i < arraySize; i++) {
            System.out.print(array[i] + ", ");
        }
        for (int i = 0; i < arraySize / 2; i++) {
            array[i] = i + 1;
            actualSize += 1;
        }
        System.out.println();
        for (int i = 0; i < arraySize; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.print("Insert at position? ");
        int position = scanner.nextInt();
        if (position <= 0 || position > arraySize) {
            System.out.println("Invalid position");
        } else {
            System.out.print("What value do you want to insert ? ");
            int value = scanner.nextInt();
            for (int i = actualSize - 1; i >= position - 1; i--) { //does shifting if there is need
                array[i + 1] = array[i];
            }
            array[position - 1] = value;
            System.out.println("After insertion ");
            for (int i = 0; i < arraySize; i++) {
                System.out.print(array[i] + ", ");
            }
        }


        //position: start counting from 1;
        //Index: start counting from zero


    }


}
