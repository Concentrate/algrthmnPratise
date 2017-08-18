package OjPratise;

import AlgrithmnPratise.ConstantsVariable;
import sun.nio.cs.ext.MacHebrew;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/8/12.
 */
public class Main {
    public static void main(String[] argv) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = scanner.nextInt();
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 0;
        result[2] = Math.abs(array[2] - array[1]);
        for (int i = 3; i <= n; i++) {
            int tmpMaxGap = Integer.MIN_VALUE;
            int record = 0;
            for (int a1 = 1; a1 < i - 1; a1++) {
                int tmpGap = Math.abs(array[i] - array[a1]) + Math.abs(array[i] - array[a1 + 1])-Math.abs(array[a1]-array[a1+1]);
                if (tmpGap > tmpMaxGap) {
                    tmpMaxGap = tmpGap;
                    record = a1;
                }
            }
            result[i] = result[i - 1] + tmpMaxGap;
            array = changeArray(array, record, i);
        }
        System.out.println(result[n]);
//        int []arr1={0,1,2,3,4,5};
//        int []arr2=changeArray(arr1,1,5);
//        displayArray(arr2);
    }

    private static void displayArray(int[] arr2) {
        for(int a1=1;a1<arr2.length;a1++){
            System.out.print(arr2[a1]+" ");
        }
    }


    private static int[] changeArray(int[] array, int record, int end) {
        int[] newArray = new int[array.length];
        int index = 1;
        for (int a1 = 1; a1 < array.length && index < array.length; a1++) {
            if (index == record + 1) {
                newArray[index] = array[end];
                a1--;
            } else {
                if (a1 == end) {
                    continue;
                } else {
                    newArray[index] = array[a1];
                }
            }
            index++;
        }
        return newArray;

    }
}
