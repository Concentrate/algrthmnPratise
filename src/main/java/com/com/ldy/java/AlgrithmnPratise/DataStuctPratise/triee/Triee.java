package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.triee;

import org.jetbrains.annotations.NotNull;
import org.springframework.util.StringUtils;
import sun.text.normalizer.Trie;

import java.io.*;
import java.util.*;

/**
 * @author: liudeyu
 * @date: 2020/11/9
 */
public class Triee {


    void constructTriee(TrieeNode root, String content, int code) {
        if (StringUtils.isEmpty(content) || root == null) {
            return;
        }
        Character word = content.charAt(0);
        int index = word - TrieeNode.BASE_INDEX_CHAR;
        if (index < 0) {
            throw new IllegalArgumentException("参数不规范: " + word);
        }
        if (root.elements[index] == null) {
            root.elements[index] = new TrieeNode();
            root.elements[index].curChar = word;
        }
        root.elements[index].passCode.add(code);
        String nextStr = content.substring(1);
        if (StringUtils.isEmpty(nextStr)) {
            root.elements[index].wordCount++;
            return;
        }
        constructTriee(root.elements[index], nextStr, code);
    }

    void deleteTrieeNode(TrieeNode root, String content, int code) {
        if (StringUtils.isEmpty(content) || root == null) {
            return;
        }
        Character word = content.charAt(0);
        int index = word - TrieeNode.BASE_INDEX_CHAR;
        if (root.elements[index] == null) {
            return;
        }

        String nextStr = content.substring(1);
        if (StringUtils.isEmpty(nextStr)) {
            root.elements[index].wordCount--;
            root.elements[index].passCode.remove(code);
            if (root.elements[index].wordCount == 0) {
                root.elements[index] = null;
            }
            return;
        }
        deleteTrieeNode(root.elements[index], nextStr, code);
    }


    int getWordCount(TrieeNode root, String content) {
        if (StringUtils.isEmpty(content) || root == null) {
            return 0;
        }
        Character word = content.charAt(0);
        int index = word - TrieeNode.BASE_INDEX_CHAR;
        if (root.elements[index] == null) {
            return 0;
        }
        String nextStr = content.substring(1);
        if (StringUtils.isEmpty(nextStr)) {
            return root.elements[index].wordCount;
        }

        return getWordCount(root.elements[index], nextStr);
    }


    Set<Integer> searchWorldWithPre(TrieeNode trieeNode, String search) {

        if (trieeNode == null || StringUtils.isEmpty(search)) {
            return new HashSet<>();
        }
        int index = search.charAt(0) - TrieeNode.BASE_INDEX_CHAR;
        if (trieeNode.elements[index] == null) {
            return new HashSet<>();
        }
        String nextStr = search.substring(1);
        if (StringUtils.isEmpty(nextStr)) {
            return trieeNode.elements[index].passCode;
        }
        return searchWorldWithPre(trieeNode.elements[index], nextStr);
    }

    public static boolean isAllAlpha(String content) {
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        for (Character tmp : content.toCharArray()) {
            if (!Character.isAlphabetic(tmp)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("./tmp.txt");
        Scanner scanner = new Scanner(fileInputStream);
        TrieeNode root = new TrieeNode();
        Triee triee = new Triee();
        SortedSet<String> recordContent = new TreeSet<>();
        String[] searchArray = new String[10000];
        int index = -1;
        while (scanner.hasNext()) {
            String lineContent = scanner.nextLine();
            String[] twoStrArr = lineContent.split("\\s+");
            Integer code;
            String content;
            code = Integer.valueOf(twoStrArr[0]);
            content = twoStrArr[1].toLowerCase();
            if (StringUtils.isEmpty(content) || !isAllAlpha(content)) {
                continue;
            }
            recordContent.add(content);
            searchArray[++index] = content;
            triee.constructTriee(root, content, index);

        }

//        recordContent.forEach(bText -> {
//            System.out.println(String.format("the content is %s ,the count is %s", bText, triee.getWordCount(root, bText)));
//
//        });
        triee.searchWorldWithPre(root, "go").stream().forEach(tmp ->
                System.out.println(String.format("common prefix word is %s", searchArray[tmp]))
        );


    }

}
