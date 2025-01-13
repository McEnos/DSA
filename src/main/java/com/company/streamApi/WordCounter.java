package com.company.streamApi;

import java.util.Objects;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");
        String word = sc.nextLine();
        Scanner newScanner = new Scanner(System.in);
        String s = newScanner.nextLine();
        System.out.println(countWords(word));
    }

    private static int countWords(String word) {
        if (Objects.isNull(word) || word.isBlank()) {
            return 0;
        }
        String[] words = word.trim().split("\\s+");
        return words.length;
    }
}
