package com.company.codility;

//https://github.com/jmornar/codility-java-solutions/tree/master
//https://codility-solutions.com/lessons/lesson-1-iterations/binarygap/
//https://github.com/DavidHerBet/java-codility
//https://github.com/Mickey0521/Codility
public class BinaryGap {
    public static void main(String[] args) {
        solution(40);
    }

    private static int solution(int N) {
        int maxGap = 0; //this is used to track the final max gap
        int currentGap = 0; //used to track gap during iteration
        boolean isCounting = false;
        String binaryString = Integer.toBinaryString(N);
        System.out.println(binaryString);
        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') { //if 1, then, I need to reset and start counting again, hence the need to check it I am counting so as to reset back to 0
                //then
                if (isCounting) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                isCounting = true;
                currentGap = 0;
            } else if (isCounting) {
                currentGap += 1;
            }
        }
        return maxGap;
    }
}
