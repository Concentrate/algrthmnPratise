package com.ldy.java.StringOpeate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liudeyu on 2017/6/7.
 */
public class TestRegex {
    public static void main(String[]args){
        String test="add    (mul  4  (add   1 2))  (mod (div 9 5 ) 9 ))";
        Pattern pattern=Pattern.compile("\\w+|\\s+\\(\\w+.*?\\)(\\s+|\\))|\\d");
        Matcher matcher=pattern.matcher(test);

        Pattern pattern1=Pattern.compile("(\\s+\\((\\w+.*?)\\)\\s+)");
        Matcher matcher1=pattern1.matcher(test);

        Pattern pattern2=Pattern.compile("(\\w+)\\s+(\\d+|\\(\\w+.*?\\))\\s+(\\(\\w+.*\\)|\\d)");
        Matcher matcher2=pattern2.matcher(test);
        while (matcher2.find()) {
            System.out.print(matcher2.start()+":");
            System.out.print(matcher2.group(1)+"\n");
            System.out.print(matcher2.group(2)+"\n");
            System.out.print(matcher2.group(3));
        }

    }
}
