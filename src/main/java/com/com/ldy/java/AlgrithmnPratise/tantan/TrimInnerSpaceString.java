package com.com.ldy.java.AlgrithmnPratise.tantan;

public class TrimInnerSpaceString {


    public char[] trimInnerSpace(char[] content) {
        if (content == null || content.length == 0) {
            return content;
        }

        int firstIndex = 0, charIndex = 0;
        char space = ' ';
        while (charIndex < content.length) {
            int tmpCount = 0;

            while (content[firstIndex] == space && tmpCount < 1) {
                tmpCount++;
                firstIndex++;
            }

            if (tmpCount >= 1) {
                int tmpRecord = firstIndex;
                while (charIndex < content.length && content[charIndex] == space) {
                    charIndex++;
                }
                while (charIndex < content.length) {
                    content[firstIndex++] = content[charIndex++];
                }
                firstIndex = tmpRecord;
                charIndex = tmpRecord;
            }

            content[firstIndex] = content[charIndex];
            firstIndex++;
            charIndex++;
        }
        char[] result = new char[firstIndex];
        for (int a1 = 0; a1 < firstIndex; a1++) {
            System.out.print(content[a1]);
            result[a1] = content[a1];
        }
        System.out.println();
        return result;

    }

    public static void main(String[] args) {

        char[] input = new char[]{'a', 'b', 'c', ' ', ' ', ' ', 'd', 'e', ' ', ' ', 'g', ' ', 'h'};
        TrimInnerSpaceString trimInnerSpaceString = new TrimInnerSpaceString();
        trimInnerSpaceString.trimInnerSpace(input);

    }
}
