package com.com.ldy.java.AlgrithmnPratise;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.IntegerTreeNode.TreeNode;

import java.util.*;

public class ZipPrintBTree {


    public static void zipPrintTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Deque<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.push(treeNode);
        boolean leftOrRight = true;

        Map<TreeNode, Integer> sonAtLine = new HashMap<>();
        int line = 0;
        int parentNodeNum = 1;
        int sonInputNode = 0;
        Deque<TreeNode> result = new LinkedList<>();
        while (!tmpQueue.isEmpty()) {

            TreeNode tmpRoot = tmpQueue.poll();
            result.add(tmpRoot);
            parentNodeNum--;


            if (tmpRoot.left != null) {
                tmpQueue.add(tmpRoot.left);
                sonInputNode++;

            }

            if (tmpRoot.right != null) {
                tmpQueue.add(tmpRoot.right);
                sonInputNode++;
            }

            if (parentNodeNum == 0) {
                TreeNode pintNode = null;
                if (leftOrRight) {
                    while ((pintNode = result.poll()) != null) {
                        System.out.print(pintNode.val + " ");
                    }
                } else {
                    while ((pintNode = result.pollLast()) != null) {
                        System.out.print(pintNode.val + " ");
                    }
                }

                leftOrRight = !leftOrRight;
                System.out.println();
                parentNodeNum = sonInputNode;
                sonInputNode = 0;
            }

        }


    }

    public static void main(String[] args) {

        TreeNode treeNode=new TreeNode(1).setLeft(new TreeNode(2).setLeft(new TreeNode(4)).setRight(new TreeNode(5)))
                .setRight(new TreeNode(3).setLeft(new TreeNode(6)).setRight(new TreeNode(7)));
        zipPrintTree(treeNode);


    }
}
