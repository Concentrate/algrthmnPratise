package com.com.ldy.java.DataStuctPratise.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liudeyu on 2019/12/2.
 */
public class TreeUtils {


    public static void printTree(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.offer(tree);

        int parentNodeCount = 1;
        int childNodeCount = 0;
        while (!tmpQueue.isEmpty()) {
            TreeNode curVa = tmpQueue.poll();
            if (curVa.left != null) {
                tmpQueue.offer(curVa.left);
                childNodeCount++;

            }
            if (curVa.right != null) {
                tmpQueue.offer(curVa.right);
                childNodeCount++;

            }
            System.out.print(curVa.val +" ");
            parentNodeCount--;
            if (parentNodeCount == 0) {
                parentNodeCount = childNodeCount;
                childNodeCount = 0;
                System.out.println();
            }
        }
    }

    private static void printNodeValueWithLineNum(Object value, int line, int totalLines) {
        int cacluSpace = 1 << totalLines;
        int spaceNum = 1 << (totalLines - line);
        for (int i = 1; i <= spaceNum; i++) {
            System.out.print(" ");
        }

    }

    private static int cacluTreeNodeLines(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        int lines = 0;
        int childCount = 0, parentCount = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
                childCount++;
            }
            if (current.right != null) {
                queue.offer(current.right);
                childCount++;
            }
            parentCount--;
            if (parentCount <= 0) {
                lines++;
                parentCount = childCount;
                childCount = 0;
            }
        }
        return lines;
    }
}
