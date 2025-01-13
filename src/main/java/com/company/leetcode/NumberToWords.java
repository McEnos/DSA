package com.company.leetcode;

public class NumberToWords {
    private static final String[] belowTwenty = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"
    };

    private static final String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };
    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(1234567));
    }
    private static String solution(int num){
        if (num == 0) return "Zero";
        int i = 0;
        String words = "";
        // Process the number in chunks of thousands
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }
    // Helper function to convert numbers < 1000 to words
    private static String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return belowTwenty[num] + " ";
        else if (num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return belowTwenty[num / 100] + " Hundred " + helper(num % 100);
    }
}
