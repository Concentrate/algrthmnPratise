package com.com.ldy.java.ProgrameLanaguageTask;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liudeyu on 2017/6/7.
 */
public class CacluLisp {

    private static final String ADD = "add";
    private static final String MUL = "mul";
    private static final String MOD = "mod";
    private static final String DIV = "div";
    private static final String SUB = "sub";
    private static Set Operation = new HashSet();
    private static int INT_TYPE = 1;
    private static int FLOAT_TYPE = 2;
    private static int NO_NUM = 0x98763272;

    static float analysisLisp(String material) {
        if (material == null || material.equals("")) {
            return 0;
        } else {
            int a1 = 0;
            while (a1 < material.length() && Character.isSpaceChar(material.charAt(a1))) {
                a1++;
            }
            while (a1 < material.length() && material.charAt(a1) == '(') {
                a1++;
            }
            if (a1 < material.length()) {
                String filterSpaceString = material.substring(a1);
                String[] spliteSpaceArray = filterSpaceString.split("\\s+");
                Pattern pattern = Pattern.compile("([a-zA-Z]+)\\s+(\\d+[\\d.]*|\\(\\w+.*?\\))\\s+(\\(\\w+.*\\)|\\d+[\\d.]*)");
                Matcher matcher = pattern.matcher(filterSpaceString);
                if (spliteSpaceArray.length > 0) {
                    if (isNumGetType(spliteSpaceArray[0]) != NO_NUM) {
                        return isNumGetType(spliteSpaceArray[0]);
                    } else if (matcher.find()) {
                        String tmpOpearor = "";
                        tmpOpearor = matcher.group(1);
                        if (Operation.contains(tmpOpearor)) {
                            // todo 加减乘除识别操作

                            String match1 = null, match2 = null;
                            match1 = matcher.group(2);
                            match2 = matcher.group(3);
                            switch (tmpOpearor.toLowerCase()) {
                                case ADD:
                                    return analysisLisp(match1) + analysisLisp(match2);
                                case MUL:
                                    return analysisLisp(match1) * analysisLisp(match2);
                                case SUB:
                                    return analysisLisp(match1) - analysisLisp(match2);
                                case DIV:
                                    return analysisLisp(match1) / analysisLisp(match2);
                                case MOD:
                                    return analysisLisp(match1) % analysisLisp(match2);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static float isNumGetType(String s) {
        if (s == null || s.length() == 0) {
            return NO_NUM;
        }
        StringBuilder builder = new StringBuilder();
        for (int a1 = 0; a1 < s.length(); a1++) {
            if (s.charAt(a1) != ')') {
                builder.append(s.charAt(a1));
            }
        }
        String toParserString = builder.toString();
        float result;
        try {
            result = Float.parseFloat(toParserString);
        } catch (Exception e) {
            result = NO_NUM;
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream("/Users/liudeyu/Documents/有用文档/编程语言2.2测试用例"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Operation.add(ADD);
        Operation.add(SUB);
        Operation.add(MUL);
        Operation.add(DIV);
        Operation.add(MOD);
        String rawLine;
        int index = 1;
        while (in.hasNext() && !(rawLine = in.nextLine()).equals("")) {
            System.out.println("第 " + index + " 次数测试:");
            index++;
            System.out.print(rawLine + "   " + "\n");
            System.out.println("result is " + analysisLisp(rawLine));
        }


    }
}
