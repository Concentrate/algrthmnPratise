package com.com.ldy.java.AlgrithmnPratise.ArrayPratise;

/**
 * @author: liudeyu
 * @date: 2020/11/13
 */

/*
```text
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
```

* */
public class MinimumSubArrayPratise {


    int minimumSubArraySize(int[] tmpArray, int limitSize) {
        if (tmpArray == null || tmpArray.length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int tmpSum = 0;
        for (int leftIndex = 0, rightIndex = 0; rightIndex < tmpArray.length; rightIndex++) {
            tmpSum += tmpArray[rightIndex];
            while (tmpSum >= limitSize) {
                result = Math.min(result, rightIndex - leftIndex + 1);
                tmpSum -= tmpArray[leftIndex++];
            }

        }
        return result;
    }

    public static void main(String[] args) {

        MinimumSubArrayPratise minimumSubArrayPratise = new MinimumSubArrayPratise();
        System.out.println(minimumSubArrayPratise.minimumSubArraySize(new int[]{2, 3, 1, 2, 4, 3}, 7));

    }
}
