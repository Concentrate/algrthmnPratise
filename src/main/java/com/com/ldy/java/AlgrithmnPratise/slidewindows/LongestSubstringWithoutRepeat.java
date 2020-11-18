package com.com.ldy.java.AlgrithmnPratise.slidewindows;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstringWithoutRepeat {


    public int getMaxNotRepeatSubString(String content) {
        if (content == null || content.isEmpty()) {
            return 0;
        }

        Set<Character> ifRepeatRecord = new HashSet<>();
        int result = Integer.MIN_VALUE;
        for (int left = 0, right = 0; right < content.length(); right++) {
            if (!ifRepeatRecord.contains(content.charAt(right))) {
                ifRepeatRecord.add(content.charAt(right));
            } else {

                while (content.charAt(left) != content.charAt(right)) {
                    ifRepeatRecord.remove(content.charAt(left++));
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;

    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeat substringWithoutRepeat=new LongestSubstringWithoutRepeat();
        System.out.println(substringWithoutRepeat.getMaxNotRepeatSubString("abcabcbb"));
        System.out.println(substringWithoutRepeat.getMaxNotRepeatSubString("bbb"));
        System.out.println(substringWithoutRepeat.getMaxNotRepeatSubString("abcdegg"));


    }
}
