package com.company.codingproblems.one;

public class ReverseLetters {
    public static void main(String[] args) {
        System.out.println(solution("Joshua hi"));
    }

    private static String solution(String value) {
        StringBuilder reverseWords = new StringBuilder();
        String whiteSpace = " ";
        for(int i = value.length() - 1; i >= 0; i--){
            reverseWords.append(value.charAt(i));
        }
       /* String[] words = value.split(whiteSpace);
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }
            reverseWords.append(reversedWord);
        }*/
        return reverseWords.toString();
    }
}
