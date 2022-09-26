package com.com.ldy.java.common;

public class FindMinPath {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    TreeNode findMinParent(TreeNode root, TreeNode first, TreeNode second) {

        if (root == first || root == second) {
            return root;
        }

        TreeNode leftParent = findMinParent(root.left, first, second);
        TreeNode rightParent = findMinParent(root.right, first, second);
        if (leftParent != null && rightParent != null) {
            return root;
        } else if (leftParent != null && rightParent == null) {
            return leftParent;
        } else if (leftParent == null && rightParent != null) {
            return rightParent;
        } else {
            return null;
        }

    }

    int getTreeHeight(TreeNode tmp) {
        if (tmp == null) {
            return 0;
        }
        return Math.max(getTreeHeight(tmp.left), getTreeHeight(tmp.right)) + 1;
    }

    private static int NO_EXIST = -0x9484923;

    int getTopFromNode(TreeNode root, TreeNode subNode) {

        if (root == null) {
            return NO_EXIST;
        }
        if (root == subNode) {
            return 0;
        }
        int fromLeft = getTopFromNode(root.left, subNode);
        if (fromLeft == NO_EXIST) {
            return getTopFromNode(root.right, subNode) + 1;
        } else {
            return fromLeft + 1;
        }
    }


    int minPathTwoNode(TreeNode root, TreeNode first, TreeNode second) {
        if (root == null) {
            return 0;
        }
        TreeNode commonPa = findMinParent(root, first, second);
        if (commonPa != first && commonPa != second) {
            return getTopFromNode(commonPa, first) + getTopFromNode(commonPa, second);
        }

        return Math.abs(getTopFromNode(commonPa, first) - getTopFromNode(commonPa, second));

    }

    public static void main(String[] args) {


    }
}
