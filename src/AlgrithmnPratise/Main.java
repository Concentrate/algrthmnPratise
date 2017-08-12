package AlgrithmnPratise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static int judgeHowManyOne(int[] tmpList, int start, int end,int number) {
        if (start > end) {
            return 0;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (tmpList[i] == number) {
                sum++;
            }
        }
        return sum;
    }

    static int myAns(int[] timeList) {
        int[] record = new int[timeList.length + 1];
        record[0] = 0;
        for (int i = 1; i <= timeList.length; i++) {
            int tmpMax = 0;
            for (int j = 1; j < i; j++) {
                int k = record[j] + judgeHowManyOne(timeList, j, i - 1,1);
                if (tmpMax < k) {
                    tmpMax = k;
                }
            }
            record[i]=Math.max(tmpMax,judgeHowManyOne(timeList,0,i-1,0));
        }
        return record[timeList.length];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _timeList_size = 0;
        _timeList_size = Integer.parseInt(in.nextLine().trim());
        int[] _timeList = new int[_timeList_size];
        int _timeList_item;
        for (int _timeList_i = 0; _timeList_i < _timeList_size; _timeList_i++) {
            _timeList_item = Integer.parseInt(in.nextLine().trim());
            _timeList[_timeList_i] = _timeList_item;
        }

        res = myAns(_timeList);
        System.out.println(String.valueOf(res));

    }
}