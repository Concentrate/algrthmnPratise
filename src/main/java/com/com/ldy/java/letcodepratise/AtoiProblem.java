package com.com.ldy.java.letcodepratise;

import java.util.HashMap;
import java.util.Map;

public class AtoiProblem {

    public int myAtoi(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        if (str.trim().length() == 1) {
            if (vailuNum(str.charAt(0))) {
                return parseStrToInt(str.charAt(0));
            } else {
                return 0;
            }
        }

        str = str.trim();
        int index = 0;
        if (index < str.length() && (vailuNum(str.charAt(index)) || (str.charAt(index) == '+' || str.charAt(index) == '-'))) {

        } else {
            return 0;
        }

        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            if (vailuNum(str.charAt(index + 1))) {

            } else {
                return 0;
            }
        }

        StringBuilder numBuilder = new StringBuilder();
        numBuilder.append(str.charAt(index++));
        while (index < str.length()) {
            if (vailuNum(str.charAt(index))) {
                numBuilder.append(str.charAt(index));
            } else if (str.charAt(index) == '.') {
                break;
            }
            index++;
        }
        int result = 0;

        if (numBuilder.length() > 1) {
            try {
                result = Integer.valueOf(numBuilder.toString());
            } catch (NumberFormatException ex) {
                if (vailuNum(numBuilder.charAt(0)) || numBuilder.charAt(0) == '+') {
                    result = Integer.MAX_VALUE;
                } else {
                    result = Integer.MIN_VALUE;
                }
            }
        } else if (vailuNum(numBuilder.charAt(0))) {
            result = parseStrToInt(str.charAt(0));
        }

        return result;

    }


    private boolean vailuNum(Character character) {
        return parseStrToInt(character) >= 0 && parseStrToInt(character) <= 9;
    }

    private int parseStrToInt(Character character) {
        int tmp = character - '0';
        return tmp;
    }

    public static void main(String[] args) {
        AtoiProblem atoiProblem = new AtoiProblem();
        System.out.println(atoiProblem.myAtoi("42"));

    }
}
