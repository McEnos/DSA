package com.company.codility;

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10,85,30));
    }

    private static int solution(int X, int Y, int D) {
        //Calculate the distance to cover:
        //If the distance isn’t perfectly divisible by D, we need to round up to ensure the frog reaches or passes the target.
        return (int) Math.ceil((double)(Y - X) / D);
    }
}
