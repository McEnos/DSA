package com.company.codingproblems.one;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String name = "Joshua ENos";
        System.out.println(name.indent(10));
        System.out.println(solution(new String[]{"flower", "flow", "flight"}));
    }

    private static String solution(String[] values) {
        if (values == null || values.length == 0)
            return "";
        String prefix = values[0];
        for (int i = 1; i < values.length; i++) {
            while (values[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    private static String solutionV2(String[] strings) {
        if (strings == null || strings.length == 0)
            return "";
        String result = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (!strings[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;

    }
}
