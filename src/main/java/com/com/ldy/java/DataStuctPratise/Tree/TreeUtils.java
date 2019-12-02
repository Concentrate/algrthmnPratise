package com.com.ldy.java.DataStuctPratise.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liudeyu on 2019/12/2.
 */
public class TreeUtils {


    public static void printTree(TreeNode<Integer> tree) {
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

            System.out.print(curVa.value + "  ");
            parentNodeCount--;
            if (parentNodeCount == 0) {
                parentNodeCount = childNodeCount;
                childNodeCount = 0;
                System.out.println();
            }
        }
    }
}
