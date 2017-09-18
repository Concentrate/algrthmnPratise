package AlgrithmnPratise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/4/5.
 */
public class MaxIncrementSubArray {
    public static String DATA_PATH = "/users/liudeyu/data.txt";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(DATA_PATH));
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
//            int[] maxIncrementNum = new int[n + 1];
//            maxIncrementNum[0] = 0;
//            /** 动态规划的动态转移方程思想*/
//            for (int i = 1; i <= n; i++) {
//                int maxSubLength = 0;
//                int tmpa = array[i - 1];
//                for (int j = 1; j < i; j++) {
//                    if (maxIncrementNum[j] > maxSubLength && array[j - 1] < array[i - 1]) {
//                        maxSubLength = maxIncrementNum[j];
//                    }
//                }
//                maxIncrementNum[i] = Math.max(maxSubLength + 1, 1);
//            }
            int result=getMaxIncrementSubArrayLength(array);
            System.out.println("the max increment sub array num is " +result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getMaxIncrementSubArrayLength(int[] array) {
        if (array == null) {
            return 0;
        }
        int[] result = new int[array.length];
        result[0] = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 1;
            }
        }
        return result[array.length-1];
    }
}
