package com.company.codingproblems.one;

//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    static Map<Character, Integer> countDuplicates(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (char ch : s.toCharArray()) {
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);

        }

        return result;
    }

    static Map<Character, Long> countingDuplicatesCharacters(String s) {
        Map<Character, Long> result = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }

    static char firstNonDuplicateCharacter(String s) {
        Map<Character, Long> result = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        //insertion-order map
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return Character.MIN_VALUE;
    }

    static String reverseWords(String s) {
        final String WHITESPACE = " ";
        StringBuilder reversedString = new StringBuilder();
        String[] words = s.split(WHITESPACE);
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }
            reversedString.append(reversedWord);
        }
        return reversedString.toString();
    }

    static String reverseWords2(String s) {
        final Pattern PATTERN = Pattern.compile(" +");
        return PATTERN.splitAsStream(s)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
    }

    static String reverseWords3(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static boolean containsOnlyDigits(String s) {
        for (char ch : s.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    static boolean containsOnlyDigits2(String s) {
        return s.chars()
                .allMatch(Character::isDigit);
    }

    static boolean containsOnlyDigits3(String s) {
        return s.matches("[0-9]+");
    }

/*    static Pair<Integer, Integer> countVowelsAndConsonants(String s) {
        final Set<Character> allVowels = new HashSet<>(
                Arrays.asList('a', 'b', 'i', 'o', 'u')
        );
        s = s.toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for (char c : s.toCharArray()) {
            if (allVowels.contains(c)) {
                vowels += 1;
            } else if (c >= 'a' && c <= 'z') {
                consonants += 1;
            }
        }
        return Pair.of(vowels, consonants);

    }*/
/*
    static Pair<Long, Long> countVowelsAndConsonants2(String s) {
        final Set<Character> allVowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u')
        );
        s = s.toLowerCase();
        long vowels = s.chars()
                .filter(c -> allVowels.contains((char) c))
                .count();
        long consonants = s.chars()
                .filter(c -> !allVowels.contains((char) c))
                .filter(c -> c >= 'a' && c <= 'z')
                .count();
        return Pair.of(vowels, consonants);
    }*/

    static int countOccurrencesOfACertainCharacter(String s, char ch) {
        return s.length() - s.replace(String.valueOf(ch), "").length();
    }

    static int countOccurrencesOfACertainCharacter2(String s, char ch) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Objects.equals(ch, c)) {
                count += 1;
            }
        }
        return count;
    }

    static int countOccurrencesOfACertainCharacter3(String s, char ch) {
        return (int) s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c.equals(ch))
                .count();
    }
/*
    static int countOccurrencesOfACertainCharacter4(String s, char ch) {
        return StringUtils.countMatches(s, ch);
    }

    static String removeWhitespaces(String s) {
        return s.replaceAll("\\s", "");
    }

    static String removeWhitespaces2(String s) {
        return StringUtils.deleteWhitespace(s);
    }*/

    static String joinByDelimiter(char delimiter, String... args) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            sb.append(args[i]).append(delimiter);
        }
        sb.append(args[i]);
        return sb.toString();
    }

 /*   static String joinByDelimiter2(char delimiter, String... args) {
        return StringUtils.join(delimiter, args);
    }*/

    static int findDuplicate(int[] nums) {
        //Arrays.asList(nums).contains(90);
        //Arrays.sort(nums);
        if (nums.length == 0)
            return nums[0];
        Map<Integer, Integer> result = new HashMap<>();
        for (Integer i : nums) {
            result.put(i, result.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
