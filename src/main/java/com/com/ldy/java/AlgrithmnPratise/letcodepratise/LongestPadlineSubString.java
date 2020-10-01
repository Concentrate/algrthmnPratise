package com.com.ldy.java.AlgrithmnPratise.letcodepratise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liudeyu on 2020/2/23.
 */

/**
 * 最长的回文子串
 */
public class LongestPadlineSubString {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        if (isPalindrome(s, 0, s.length() - 1)) {
            return s;
        }

        String finnalRes = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            List<Integer> allRightIndex = findAllCharIndex(s, s.charAt(i));
            for (Integer bRightIndex : allRightIndex) {
                if (bRightIndex == i) {
                    break;
                }
                int rightIndex = bRightIndex;
                if (isPalindrome(s, i, rightIndex)) {
                    String findSub = s.substring(i, rightIndex + 1);
                    if (findSub.length() > finnalRes.length()) {
                        finnalRes = findSub;
                    }
                }

            }
        }
        return finnalRes;

    }


    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        if (isPalindrome(s, 0, s.length() - 1)) {
            return s;
        }

        return "";
    }


    List<Integer> findAllCharIndex(String tmp, Character target) {
        List<Integer> result = new ArrayList<>();
        for (int i = tmp.length() - 1; i >= 0; i--) {
            if (tmp.charAt(i) == target) {
                result.add(i);
            }
        }
        return result;
    }

    boolean isPalindrome(String tmp, int startIndex, int endIndex) {
        boolean resultOk = true;
        while (startIndex < endIndex) {
            if (tmp.charAt(startIndex) != tmp.charAt(endIndex)) {
                resultOk = false;
                break;
            }
            startIndex++;
            endIndex--;
        }
        return resultOk;

    }

    public static void main(String[] argv) {

        LongestPadlineSubString padlineSubString = new LongestPadlineSubString();
        System.out.println(padlineSubString.longestPalindrome("babadada"));
    }
}
