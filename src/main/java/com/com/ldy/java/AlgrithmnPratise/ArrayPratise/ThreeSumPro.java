package com.com.ldy.java.AlgrithmnPratise.ArrayPratise;

import com.com.ldy.java.AlgrithmnPratise.utils.ListUtils;
import com.com.ldy.java.common.CollectionUtil;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author: liudeyu
 * @date: 2020/11/13
 */

  /*
    给你一个包含 n 个整数的数组  nums，判断  nums  中是否存在三个元素 a，b，c ，使得  a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

    * */
public class ThreeSumPro {


    /**
     * O(n^2)
     * use set save all num
     * every time find if check
     * set contain, worst time spend O(n^2)
     */
    Set<Integer> getThreeSumZeor(int[] tmpArray) {

        return null;
    }


    Set<List<Integer>> getThreeSumZero(int[] tmpArray) {

        if (tmpArray == null || tmpArray.length == 0) {
            return new HashSet<>();
        }

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(tmpArray);
        for (int i = 0; i < tmpArray.length - 2; i++) {

            int left = i + 1;
            int right = tmpArray.length - 1;

            if (tmpArray[i] > 0) {
                break;
            }
            if (i > 0 && tmpArray[i] == tmpArray[i - 1]) {
                continue;
            }

            while (left < right) {

//                if (left > 0 && tmpArray[left] == tmpArray[left - 1]) {
//                    left++;
//                    continue;
//                }
//
//                if (right > 0 && tmpArray[right] == tmpArray[right - 1]) {
//                    right--;
//                    continue;
//                }
                if (tmpArray[i] + tmpArray[left] + tmpArray[right] < 0) {
                    left++;
                } else if (tmpArray[i] + tmpArray[left] + tmpArray[right] > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(tmpArray[i]);
                    list.add(tmpArray[left]);
                    list.add(tmpArray[right]);
                    result.add(list);
                    left++;
                    right--;
                }

            }
        }
        return result;

    }


    public static void main(String[] args) {

        ThreeSumPro threeSumPro = new ThreeSumPro();
        Set<List<Integer>> solve = threeSumPro.getThreeSumZero(new int[]{-1, 0, 1, 2, -1, -4});
        Iterator<List<Integer>> setIter = solve.iterator();
        while (setIter.hasNext()) {
            ListUtils.printList(setIter.next(), 0);
        }
    }
}
