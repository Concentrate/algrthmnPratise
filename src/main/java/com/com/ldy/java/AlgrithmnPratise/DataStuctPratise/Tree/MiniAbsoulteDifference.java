package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.IntegerTreeNode.TreeNode;

// 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
public class MiniAbsoulteDifference {

//    int minGap = Integer.MAX_VALUE;

    int miniDifference(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        return toImplementMinDifference(treeNode, Integer.MAX_VALUE);

    }

    private int toImplementMinDifference(TreeNode treeNode, Integer lastNodeVa) {

        if (treeNode == null || lastNodeVa == null) {
            return Integer.MAX_VALUE;
        }
        int leftGap = toImplementMinDifference(treeNode.left, treeNode.val);
        int middleGap = Integer.MAX_VALUE;
        if (treeNode.val != null) {
            middleGap = Math.abs(lastNodeVa - treeNode.val);
        }
        int rightGap = toImplementMinDifference(treeNode.right, treeNode.val);
        return Math.min(leftGap, Math.min(middleGap, rightGap));
    }

    public static void main(String[] args) {

        MiniAbsoulteDifference miniAbsoulteDifference = new MiniAbsoulteDifference();
        TreeNode treeNode = TreeUtils.createLevelTravelTree(new Integer[]{1, 3, 10, 5, null, 2, null});
        System.out.println(miniAbsoulteDifference.miniDifference(treeNode));

    }
}
