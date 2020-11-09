package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.triee;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: liudeyu
 * @date: 2020/11/9
 */
public class TrieeNode {

    TrieeNode[] elements;
    int wordCount;
    Character curChar;

    // 经过的code
    Set<Integer> passCode;

    public static final Character BASE_INDEX_CHAR = 'a';

    public TrieeNode() {
        elements = new TrieeNode[26];
        passCode = new HashSet<>();
    }
}
