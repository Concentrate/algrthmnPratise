package com.com.ldy.java.AlgrithmnPratise.dynamicProgram;

/**
 * @author: liudeyu
 * @date: 2020/12/15
 */

/**
 * 最长非连续上升子串长度
 */
public class MaxNotContinueIncreaseSequenceLength {


    int subSequenceMaxIncreaseLength(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return 0;
        }

        int[] resultRecord = new int[sequence.length + 1];
        resultRecord[0] = 0;
        resultRecord[1] = 1;

        for (int a1 = 0; a1 < resultRecord.length; a1++) {
            resultRecord[a1] = 1;
        }
        for (int i = 2; i < sequence.length; i++) {
            for (int a1 = 0; a1 < i; a1++) {
                if (sequence[i] > sequence[a1]) {
                    resultRecord[i] = Math.max(resultRecord[i], resultRecord[a1] + 1);
                }
            }
        }
        int finalLongestLength = 1;
        for (int i = 0; i < sequence.length; i++) {
            finalLongestLength = Math.max(finalLongestLength, resultRecord[i]);
        }
        return finalLongestLength;

    }

    public static void main(String[] args) {

        MaxNotContinueIncreaseSequenceLength maxNotContinueIncreaseSequenceLength = new MaxNotContinueIncreaseSequenceLength();

        int[] rawArray = new int[]{10, 9, 2, 5, 3, 7, 101, 18,109,3,2,1};
        System.out.println(maxNotContinueIncreaseSequenceLength.subSequenceMaxIncreaseLength(rawArray));


    }
}
