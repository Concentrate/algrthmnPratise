package com.com.ldy.java.AlgrithmnPratise.ArrayPratise;

import com.com.ldy.java.common.CollectionUtil;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 题解 讨论 通过的代码笔记 纠错 收藏
 */
public class FindDuplicateElement {

    public class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[], int length, int[] duplication) {
            if (numbers == null || numbers.length == 0) {
                return false;
            }
            Arrays.sort(numbers);
            int lastEle = numbers[0];
            boolean findSame = false;
            for (int a1 = 1; a1 < numbers.length; a1++) {
                if (numbers[a1] == lastEle) {
                    findSame = true;
                    duplication[0] = numbers[a1];
                    break;
                }
                lastEle = numbers[a1];

            }
            return findSame;
        }
    }
}
