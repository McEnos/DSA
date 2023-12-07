package com.company.bitmanipulation;

public class Main {
    public static void main(String[] args) {
        //LSB >>> Least Significant Bit(rightmost bit)
        //MSB >>> Most Significant Bit(Leftmost bit)
        //for even number, the most right bit is zero, odd the value is 1
        //Left bit shift << n, shift bits n times to the left,
        // drop(n) bits on the left and add n zeros to the right to compensate for lost bits;
        //Right bit shift >> n, shift bits n times to the right,
        // drop(n) bits on the right and add n zeros to the left to compensate for the lost bits.
     /*   System.out.println(isEven(2));
        System.out.println(isEven(3));
        System.out.println(isEven(120));*/
       /* System.out.println(countSetBits(27));
        System.out.println(countSetBitsV3(27));
        System.out.println(countSetBits2(27));*/
       /* System.out.println(numberPowerOfTwo(33));
        System.out.println(numberPowerOfTwo(34));
        System.out.println(numberPowerOfTwo(32));
        System.out.println(numberPowerOfTwo(64));*/
        System.out.println(numberPowerOfTwo(-32));
      /*  int x = 5;
        int y = 3;
        StringBuilder sb = new StringBuilder("Joshua");
        sb.deleteCharAt(1);
     *//*   System.out.println(x & y); //AND
        System.out.println(x | y); //Or
        System.out.println(~5); //Not
        System.out.println(x ^ y); //exclusive or
        System.out.println(x << 3);
        System.out.println(x >> 1);*//*

        System.out.println(4 & 1);
        System.out.println(toggleCase("JoshUA".toCharArray()));*/

    }

    public static int countBits(int x) {
        return Integer.bitCount(x);
    }

    public static String toggleCase(char[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] ^= 32;
        }
        return new String(a);
    }

    public static boolean isEven(int value) {
        //for odd number, the LSB is one otherwise it's zero
        return (value & 1) == 0;
    }

    //Brian Kernighan's  algorithm
    public static int countSetBitsV3(int value) {
        int count = 0;
        while (value != 0) {
            value = value & (value - 1); //unsets the right most set bit.
            count += 1;
        }
        return count;
    }

    public static int countSetBits(int value) {
        int count = 0;
        while (value > 0) {
            if ((value & 1) == 1) { //checks if the LSB is one
                count += 1;
            }
            value >>= 1; // remove the LSB
        }
        return count;
    }

    public static int countSetBits2(int value) {
        return Integer.bitCount(value);
    }

    public static boolean numberPowerOfTwo(int value) {
        /* a number is power of two if it has only one set bit.
         therefore using  Brian Kernighan's  algorithm to unset the rightmost set bit, this process should only happen
         once for you to obtain zero
         */
        if (value <= 0)
            return false;
        return (value & value - 1) == 0;
    }
    /**
     * Given an integer, write a function to determine if it is a power of two.
     * we can use the bitwise AND operator to check if the number is a power of two or not.
     * If a number is a power of two, it will have only one set bit.
     */

    /**
     * Given an integer, write a function to determine if it is a power of three.
     * @param value
     * @return
     */

    public static boolean powerOfThree(int value) {
        if (value <= 0)
            return false;
        while (value >= 3) {
            if (value % 3 != 0)
                return false;
            value = value / 3;
        }
        return value == 1;
    }

    /**
     * Given an integer, write a function to determine if it is a power of four.
     * @param value
     * @return
     */

    public static boolean powerOfFour(int value) {
        if (value <= 0)
            return false;
        while (value >= 4) {
            if (value % 4 != 0)
                return false;
            value = value / 4;
        }
        return value == 1;
    }

}
