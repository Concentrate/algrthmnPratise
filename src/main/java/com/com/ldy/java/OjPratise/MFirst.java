package com.com.ldy.java.OjPratise;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by liudeyu on 2017/9/12.
 */
public class MFirst {
    static final String A = "Alice";
    static final String B = "Bob";

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(testMethod(array));
    }

    private static String testMethod(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
        }
        String tmp = builder.toString();
        Pattern pattern = Pattern.compile("^1+0+$");
        if (pattern.matcher(builder.toString()).matches()) {
            return B;
        } else if (tmp.matches("^0+1+$")) {
            return A;
        } else if(tmp.matches("^10*1$")){
            return B;
        }else if(tmp.charAt(tmp.length()-1)=='1'){
            return A;
        }else{
            return B;
        }
    }
}
