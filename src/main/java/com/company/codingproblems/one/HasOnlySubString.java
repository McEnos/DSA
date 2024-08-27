package com.company.codingproblems.one;

public class HasOnlySubString {
    public static void main(String[] args) {

    }

    private static boolean solution(String value) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length() / 2; i++) {
            sb.append(value.charAt(i));
            String resultinfString = value.replaceAll(sb.toString(),"");
            if (resultinfString.isEmpty()){
                return true;
            }
        }
        return false;
    }
}
