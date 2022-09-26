package com.com.ldy.java.common;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class AirBnbDebug {


    public static class Result {

        /*
         * Complete the 'validate_xml' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING xml as parameter.
         */

        public static String validate_xml(String xml) {
            // Write your code here
            String VAILD = "valid";
            String PARSER_ERR = "parse error";
            String DETAIL_ERR = "encountered closing tag without matching open tag for ";
            String MISSING_ERR = "missing closing tag for ";

            if (xml == null || xml.length() == 0) {
                return VAILD;
            }


            Deque<String> stack = new LinkedList<>();
            int index = 0;
            while (index < xml.length()) {
                if (xml.charAt(index) == '<') {
                    if (index < xml.length() && xml.charAt(index + 1) == '/') {
                        index=index+2;
                        StringBuilder tmpErrorInfo = new StringBuilder("<");
                        while (xml.charAt(index) != '>') {
                            if (xml.charAt(index) == '<') {
                                return PARSER_ERR;
                            }
                            tmpErrorInfo.append(xml.charAt(index));
                            index++;
                        }

                        if (tmpErrorInfo.length() == 1) {
                            return PARSER_ERR;
                        }
                        tmpErrorInfo.append(">");
                        if (stack.peek().equals(tmpErrorInfo.toString())) {
                            stack.pop();
                        } else {
                            String tmp2 = "</";
                            for (int i = 1; i < tmpErrorInfo.length(); i++) {
                                tmp2 = tmp2 + tmpErrorInfo.charAt(i);
                            }
                            return DETAIL_ERR + tmp2;
                        }
                    } else {

                        index++;
                        StringBuilder secondBuild = new StringBuilder("<");
                        while (xml.charAt(index) != '>') {
                            if (xml.charAt(index) == '<') {
                                return PARSER_ERR;
                            }
                            secondBuild.append(xml.charAt(index));
                            index++;
                        }
                        if (secondBuild.length() == 1) {
                            return PARSER_ERR;

                        }
                        secondBuild.append(">");
                        stack.push(secondBuild.toString());
                    }
                }
                index++;
            }

            if (!stack.isEmpty()) {
                return MISSING_ERR + stack.pop();
            }

            return VAILD;
        }

    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            Solution solution = new Solution();

            System.out.println(Result.validate_xml("text<a>more</a>"));
        }
    }

}
