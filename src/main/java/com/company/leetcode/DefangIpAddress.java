package com.company.leetcode;
//https://leetcode.com/problems/defanging-an-ip-address/
public class DefangIpAddress {

    public static void main(String[] args) {
        System.out.println(solution("1.1.1.1"));
        System.out.println(solution("255.100.50.0"));
    }

    private static String solution(String ip) {
        return ip.replaceAll("\\.", "[.]");
    }
}
