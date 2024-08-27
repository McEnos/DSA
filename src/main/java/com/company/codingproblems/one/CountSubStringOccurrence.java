package com.company.codingproblems.one;

public class CountSubStringOccurrence {
    public static void main(String[] args) {

    }

    private static int solution(String value, String substring) {
        int position = 0;
        int count = 0;
        int n = substring.length();
        while ((position = value.indexOf(substring)) != -1) {
            position = position + n;
            count += 1;
        }
        return count;
    }
  /*  private static int solutionV2(String value, String substring){
        int count = 0;
        String newString = value;
        while (!newString.isBlank()){

        }
    }*/

}
