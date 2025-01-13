package com.company.codility;

//https://github.com/jmornar/codility-java-solutions/tree/master
//https://codility-solutions.com/lessons/lesson-1-iterations/binarygap/
//https://github.com/DavidHerBet/java-codility
//https://github.com/Mickey0521/Codility
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solutionV2(1041));
        System.out.println(solutionV2(15));
    }

    private static int solution(int N) {
        int maxGap = 0; //this is used to track the final max gap
        int currentGap = 0; //used to track gap during iteration
        boolean isCounting = false;
        String binaryString = Integer.toBinaryString(N);
        System.out.println(binaryString);
        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') { //if 1, then, I need to reset and start counting again, hence the need to check it I am counting to reset back to 0
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

    private static int solutionV2(int N) {
        int maxGap = 0;
        //ensures that we only compute a gap after encountering at least two 1s
        //The first 1 is treated as the starting point, not as part of a gap computation.
        int previousIndex = -1; //serves a crucial role in handling the first occurrence of 1 in the binary string. tracks the position of the last seen
        String binaryString = Integer.toBinaryString(N);
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (previousIndex != -1) {
                    /**
                     * The binary gap is defined as the number of 0s between two consecutive 1s.
                     * In the steps above, we calculated the index difference (like 6 - 0 = 6),
                     * but this includes the starting 1 itself, which is incorrect.
                     */
                    maxGap = Math.max(maxGap, i - previousIndex - 1);
                }
                previousIndex = i;
            }
        }
        return maxGap;
    }
}
