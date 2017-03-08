package AlgrithmnPratise;

/**
 * Created by liudeyu on 2017/3/5.
 */

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, l;
        int left = 0, right=0;
        n = scanner.nextInt();
        l = scanner.nextInt();
        int allLenght = 0;
        int gap = 2;
        boolean isFind = false;
        while (gap <= 50) {
            int mid = n / gap;
            int i = 0, j = 0;
            int tmpSum = mid;
            int tmplength = 1;
            left=right=mid;
            while (i <= gap && j <= gap) {
                left=mid-1;
                tmpSum+=left;
                tmplength++;
                if (tmpSum > n) {
                    break;
                }
                if (tmpSum == n) {
                    if (tmplength >= l) {
                        isFind = true;
                        break;
                    }
                }
                right=mid+1;
                tmpSum+=right;
                tmplength++;
                if (tmpSum > n) {
                    break;
                }
                if (tmpSum == n) {
                    if (tmplength >= l) {
                        isFind = true;
                        break;
                    }
                }
                if(tmplength>100){
                    System.out.println("No");
                }
                i++;
                j++;
            }
            gap++;
            if (isFind) {
                break;
            }
        }
        boolean isFirst=true;
        if(isFind){
            for(int i=left;i<=right;i++){
                if(isFirst){
                    isFirst=false;
                    System.out.print(i);
                }else{
                    System.out.print(" "+i);
                }
            }
        }
        System.out.println("");

    }
}
