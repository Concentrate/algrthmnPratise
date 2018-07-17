package com.ldy.java.ProgrameLanaguageTask;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by liudeyu on 2017/6/9.
 */
public class ListElementTypeJudge {
    private static final int INT_TYPE = 0x11;
    private static final int BOOL_TYPE = 0x12;
    private static final int ERROR_TYPE = 0x13;
    static final String ADD = "add";
    static final String SUB = "sub";
    static final String DIV = "div";
    static final String MOD = "mod";
    static final String MUL = "mul";
    static Set<String> cacluOperator = new HashSet<>();

    static final String GREATER = "gt";
    static final String LESSTHAN = "lt";
    static final String EQUAL = "equ";
    static final String AND = "and";
    static final String OR = "or";
    static Set<String> logicalCompareOperator = new HashSet<>();
    static Set<String> numberCompareOperator = new HashSet<>();


    static final String NOT = "not";
    static final String TYPE_TRUE = "T";
    static final String TYPE_FALSE = "F";

    public static void main(String[] args) {
        initSet();
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;

        String file2_1="/Users/liudeyu/Documents/有用文档/编程语言work2测试用例";
        String file2_3="/Users/liudeyu/Documents/课程作业/编程语言/编程语言2.3测试用例";
        try {
            scanner = new Scanner(new FileInputStream(file2_3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String rawLine;
        int index = 1;
        while (scanner.hasNext() && !(rawLine = scanner.nextLine()).equals("")) {
            System.out.println("第 " + index + " 次测试用例： ");
            System.out.println(rawLine);
            System.out.print("返回结果类型： ");
            int type = getCacluType(rawLine);
            switch (type) {
                case INT_TYPE:
                    System.out.println("int type");
                    break;
                case BOOL_TYPE:
                    System.out.println("bool type");
                    break;
                case ERROR_TYPE:
                    System.out.println("error type");
                    break;
            }
            index++;

        }
    }

    private static void initSet() {
        cacluOperator.add(ADD);
        cacluOperator.add(SUB);
        cacluOperator.add(MUL);
        cacluOperator.add(DIV);
        cacluOperator.add(MOD);

        numberCompareOperator.add(EQUAL);
        numberCompareOperator.add(GREATER);
        numberCompareOperator.add(LESSTHAN);

        logicalCompareOperator.add(AND);
        logicalCompareOperator.add(OR);
    }

    private static int getCacluType(String rawLine) {
        if (rawLine == null || rawLine.equals("")) {
            return ERROR_TYPE;
        }
        int startIndex = 0;
        while (startIndex < rawLine.length() && Character.isSpaceChar(startIndex)) {
            startIndex++;
        }
        while (startIndex < rawLine.length() && rawLine.charAt(startIndex) == '(') {
            startIndex++;
        }
        if (startIndex < rawLine.length()) {
            String filterMetrial = rawLine.substring(startIndex);
            filterMetrial=filterMetrial.trim();
            String[] spliteArray = filterMetrial.split("\\s+");
            if (spliteArray.length >= 3) {
                String operator = spliteArray[0];
                if (cacluOperator.contains(operator) || logicalCompareOperator.contains(operator) ||
                        numberCompareOperator.contains(operator)) {
                    int a1 = filterMetrial.indexOf('(');
                    boolean isSingleElmentFirst = !spliteArray[1].contains("(");
                    String firstElement = "", secondElement;
                    if (isSingleElmentFirst) {
                        firstElement = spliteArray[1];
                    } else if (a1 != -1) {
                        firstElement = getStringForBracketElement(filterMetrial, a1);
                    }
                    a1 = filterMetrial.indexOf(firstElement) + firstElement.length();
                    while (a1 < filterMetrial.length() && Character.isSpaceChar(filterMetrial.charAt(a1))) {
                        a1++;
                    }
                    if (a1 < filterMetrial.length() && filterMetrial.charAt(a1) == '(') {
                        secondElement = getStringForBracketElement(filterMetrial, a1);
                    } else {
                        StringBuilder builder = new StringBuilder();
                        while (a1 < filterMetrial.length() && !Character.isSpaceChar(filterMetrial.charAt(a1))) {
                            builder.append(filterMetrial.charAt(a1));
                            a1++;
                        }
                        secondElement = builder.toString();
                    }
                    if (cacluOperator.contains(operator)) {
                        if (getCacluType(firstElement) == INT_TYPE && getCacluType(secondElement) == INT_TYPE) {
                            return INT_TYPE;
                        }
                    } else if (numberCompareOperator.contains(operator)) {
                        if (getCacluType(firstElement) == INT_TYPE && getCacluType(secondElement) == INT_TYPE) {
                            return BOOL_TYPE;
                        }
                    } else {
                        if (getCacluType(firstElement) == BOOL_TYPE && getCacluType(secondElement) == BOOL_TYPE) {
                            return BOOL_TYPE;
                        }
                    }
                    return ERROR_TYPE;
                } else {
                    if (!operator.equals(NOT)) {
                        return ERROR_TYPE;
                    }
                    boolean isSingleElement = !spliteArray[1].contains("(");
                    if (isSingleElement) {
                        if (getCacluType(spliteArray[1]) == BOOL_TYPE) {
                            return BOOL_TYPE;
                        }
                    } else {
                        String bracketElement = getStringForBracketElement(filterMetrial, filterMetrial.indexOf('('));
                        if (getCacluType(bracketElement) == BOOL_TYPE) {
                            return BOOL_TYPE;
                        }
                    }
                    return ERROR_TYPE;
                }

            } else if (spliteArray.length == 2) {
                String operator = spliteArray[0];
                if (!NOT.contains(operator)) {
                    return ERROR_TYPE;
                }
                int type = getCacluType(spliteArray[1]);
                if (type == BOOL_TYPE) {
                    return BOOL_TYPE;
                }

            } else {
                return getTypeOfSingleElement(spliteArray[0]);
            }

        }
        return ERROR_TYPE;
    }

    private static String getStringForBracketElement(String filterMetrial, int index) {
        LinkedList<Character> stack = new LinkedList<>();
        int leftBracketIndex = 0, rightBracketIndex = 0;
        for (int a1 = index; a1 < filterMetrial.length(); a1++) {
            if (filterMetrial.charAt(a1) == '(') {
                if (stack.isEmpty()) {
                    leftBracketIndex = a1;
                }
                stack.push('(');
            }
            if (filterMetrial.charAt(a1) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                rightBracketIndex = a1;
                break;
            }
        }

        return filterMetrial.substring(leftBracketIndex, rightBracketIndex + 1);
    }

    private static int getTypeOfSingleElement(String s) {
        StringBuilder builder = new StringBuilder();
        for (int a1 = 0; a1 < s.length(); a1++) {
            if (s.charAt(a1) != ')') {
                builder.append(s.charAt(a1));
            }
        }
        s = builder.toString();
        if (s.equals(TYPE_TRUE) || s.equals(TYPE_FALSE)) {
            return BOOL_TYPE;
        } else {
            int type = INT_TYPE;
            try {
                int num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                type = ERROR_TYPE;
            }
            return type;
        }
    }

}
