package com.com.ldy.java.AlgrithmnPratise.recursivethink;

/**
 * @author: liudeyu
 * @date: 2020/11/12
 */


import com.com.ldy.java.AlgrithmnPratise.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets pro
 * ```
 */
public class SubsetPro {


    void subsetResult(int[] tmpArr) {
        if (tmpArr == null || tmpArr.length == 0) {
            return;
        }
        toImplementSubSetResult(tmpArr, 0, new ArrayList<>(22));
    }


    void toImplementSubSetResult(int[] tmpArr, int index, List<Integer> subSet) {

        if (index >= tmpArr.length) {
            ListUtils.printList(subSet, 0);
            return;
        }


        subSet.add(tmpArr[index]);
        toImplementSubSetResult(tmpArr, index + 1, subSet);
        subSet.remove((Integer) tmpArr[index]);
        toImplementSubSetResult(tmpArr, index + 1, subSet);

    }

    public static void main(String[] args) {
        SubsetPro subsetPro=new SubsetPro();
        subsetPro.subsetResult(new int[]{1,2,3});

    }
}
