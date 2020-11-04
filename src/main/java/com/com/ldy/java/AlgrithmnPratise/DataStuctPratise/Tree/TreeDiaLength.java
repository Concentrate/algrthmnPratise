package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;

/**
 * @author: liudeyu
 * @date: 2020/11/4
 */
public class TreeDiaLength {


    int getTreeHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getTreeHeight(treeNode.left), getTreeHeight(treeNode.right)) + 1;
    }

    public int diaLength(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        }

        int leftDia = diaLength(treeNode.left);
        int rightDia = diaLength(treeNode.right);
        int passRoot = getTreeHeight(treeNode.left) + getTreeHeight(treeNode.right) + 1;

        return Math.max(leftDia, Math.max(rightDia, passRoot));
    }

    public static void main(String[] args) {

        TreeDiaLength treeDiaLength = new TreeDiaLength();
        TreeNode treeNode = TreeUtils.createTreeofN(12);
        TreeUtils.printTree(treeNode);
        System.out.println("tree Dia Length is " + treeDiaLength.diaLength(treeNode));

    }
}
