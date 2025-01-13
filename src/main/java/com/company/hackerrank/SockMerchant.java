package com.company.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class SockMerchant {
    public static void main(String[] args) {
        System.out.println(solution(9, List.of(10, 20, 20, 10, 10, 30, 50, 10, 20) ));
    }

    private static int solution(int n, List<Integer> array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int pairs = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value >= 2) {
                pairs += (value / 2);
            }
        }
        return pairs;
    }
}
