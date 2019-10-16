package com.com.ldy.java.ProgrameLanaguageTask;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/6/6.
 */
public class LispChangeToC {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream("/Users/liudeyu/Documents/有用文档/编程语言work2测试用例"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String lispString;
        LinkedList<Character> stack = new LinkedList<>();
        int countIndex=1;
        while (in.hasNext()&&!(lispString = in.nextLine()).equals("")) {
            System.out.println("第 "+countIndex+" 次测试用例 ");
            System.out.println(lispString);
            countIndex++;
            for (int a1 = 0; a1 < lispString.length(); a1++) {
                char k = lispString.charAt(a1);
                if (lispString.charAt(a1) == '(') {
                    stack.push(lispString.charAt(a1));
                } else if (Character.isAlphabetic(k)) {
                    System.out.print(k);
                    int b1 = a1 + 1;
                    while (b1 < lispString.length() && Character.isAlphabetic(lispString.charAt(b1))) {
                        System.out.print(lispString.charAt(b1));
                        b1++;
                    }
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    a1 = b1 - 1;
                } else if (Character.isDigit(k)) {
                    int b2 = a1;
                    while (b2 < lispString.length() && Character.isDigit(lispString.charAt(b2))) {
                        System.out.print(lispString.charAt(b2));
                        b2++;
                    }
                    while (b2 < lispString.length() && Character.isSpaceChar(lispString.charAt(b2))) {
                        b2++;
                    }
                    if (b2 < lispString.length() && lispString.charAt(b2) != ')') {
                        System.out.print(",");
                    }
                    a1 = b2 - 1;
                } else if (lispString.charAt(a1) == ')') {
                    System.out.print(")");
                    int b2 = a1 + 1;
                    if (b2 < lispString.length() && Character.isSpaceChar(lispString.charAt(b2))) {
                        b2++;
                    }
                    if (b2 < lispString.length() && lispString.charAt(b2) != ')') {
                        System.out.print(",");
                    }
                    a1 = b2 - 1;
                }
            }
            System.out.println("");
        }
    }
}
