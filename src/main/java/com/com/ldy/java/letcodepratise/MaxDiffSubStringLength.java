package com.com.ldy.java.letcodepratise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liudeyu on 2020/2/23.
 */
public class MaxDiffSubStringLength {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> record = new HashMap<>();
        int index = 0;
        int maxLength = 0;
        int leftStartRemove = 0;
        while (index < s.length()) {
            if (record.containsKey(s.charAt(index))) {
                maxLength = Math.max(maxLength, record.size());
                int beforeIndex = record.get(s.charAt(index));
//                record.put(s.charAt(index), index);
                for (int a1 = leftStartRemove; a1 <= beforeIndex; a1++) {
                    record.remove(s.charAt(a1));
                }
                leftStartRemove = beforeIndex + 1;
//                continue;

            }
            record.put(s.charAt(index), index);
            index++;
        }


        return Math.max(maxLength, record.size());
    }





    public static void main(String[] argv) {

    }
}
