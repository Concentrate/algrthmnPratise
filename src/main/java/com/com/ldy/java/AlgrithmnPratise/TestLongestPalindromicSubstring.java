package com.com.ldy.java.AlgrithmnPratise;

/**
 * Created by liudeyu on 2017/3/12.
 */
public class TestLongestPalindromicSubstring {
    private int maxLength = 0;
    private int left = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            extendParString(s, i, i);
            extendParString(s, i, i + 1);
        }
        return s.substring(left, left + maxLength);
    }

    private void extendParString(String s, int i, int i1) {
        while (i >= 0 && i1 < s.length() && s.charAt(i) == s.charAt(i1)) {
            i--;
            i1++;
        }
        if (i1 - i - 1 > maxLength) {
            maxLength = i1 - i - 1;
            left = i + 1;
        }

    }


    public static void main(String []args){
        TestLongestPalindromicSubstring substring=new TestLongestPalindromicSubstring();
      System.out.println("" + substring.longestPalindrome("babd"));
    }

}
