package com.company.codingproblems.one;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByLength {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Joshua", "Enos", "Odiwuor"})));
    }

    private static String[] solution(String[] value){
         Comparator<String> comparator = (a,b) -> Integer.compare(a.length(),b.length());
         Arrays.sort(value,(a,b) -> Integer.compare(a.length(),b.length()));
         return value;

    }
}
