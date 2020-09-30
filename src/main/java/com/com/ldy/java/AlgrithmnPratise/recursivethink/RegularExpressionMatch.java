package com.com.ldy.java.AlgrithmnPratise.recursivethink;

import com.ldy.java.AlgrithmnPratise.ConstantsVariable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Created by liudeyu on 2017/6/11.
 */

/**
 * 字符串匹配
 */
public class RegularExpressionMatch {


    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            if (s == null && p != null) {
                return false;
            } else if (s != null && p == null) {
                return false;
            } else {
                return true;
            }
        }
        if (s.equals(p)) {
            return true;
        }
        if (p.isEmpty() || s.isEmpty()) {
            if (p.isEmpty()) {
                return s.isEmpty();
            } else {
                String regular = "[a-zA-Z.]\\*";
                return p.matches(regular);
            }

        }
        if (p.length() >= 2) {
            if (p.charAt(1) == '*') {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                    return isMatch(s.substring(1), p);
                }
            } else {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
            }
        } else {
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return s.length() == 1;
            } else {
                return false;
            }
        }
        return false;
    }


    // 迭代方式，动态规划显得比较复杂，现在该函数结果还不对
    public boolean isMatch3(String s, String p) {
        // write your code here
        if (s == null && p == null) {
            return true;
        } else if (s == null) {
            return false;
        } else if (p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        boolean[][] result = new boolean[s.length() + 1][];
        for (int i = 0; i <= s.length(); i++) {
            result[i] = new boolean[p.length() + 1];
        }
        result[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    result[i][j] = result[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (j >= 2) {
                        if (result[i][j - 2]) {
                            result[i][j] = true;
                            break;
                        }
                    }
                    int b = i;
                    while (b >= 1 && !result[b - 1][j - 1]) {
                        b--;
                    }
                    if (b >= 1 && result[b - 1][j - 1]) {
                        result[i][j] = true;
                        break;
                    }

                } else {
                    result[i][j] = false;
                }
            }
        }
        return result[s.length()][p.length()];

    }

    public static void main(String[] args) {
        RegularExpressionMatch match = new RegularExpressionMatch();
        try {
            Scanner scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
            String raw, toMatch;
            raw = scanner.next();
            toMatch = scanner.next();
            System.out.println("result is " + match.isMatch(raw, toMatch));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
