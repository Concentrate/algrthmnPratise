package com.com.ldy.java.AlgrithmnPratise.letcodepratise;

import java.util.ArrayList;
import java.util.List;

public class IsVaildBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> midRecursive = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        midTraveserTree(root);
        boolean isVaild = true;
        return isSortedArray(midRecursive, 0, midRecursive.size() - 1);

    }

    private boolean isSortedArray(List<Integer> midRecursive, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            boolean leftSorted = isSortedArray(midRecursive, start, mid);
            boolean rightSorted = isSortedArray(midRecursive, mid + 1, end);
            boolean midSorted = midRecursive.get(mid) < midRecursive.get(mid + 1);
            return leftSorted && rightSorted&&midSorted;
        }

        return midRecursive.get(start) <= midRecursive.get(end);
    }

    private void midTraveserTree(TreeNode root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            midRecursive.add(root.val);
            return;
        }
        midTraveserTree(root.left);
        midRecursive.add(root.val);
        midTraveserTree(root.right);

    }

    public static void main(String[] args) {
        IsVaildBST isVaildBST = new IsVaildBST();
        TreeNode tmp = new TreeNode(2);
        tmp.left = new TreeNode(1);
        tmp.right = new TreeNode(3);
        System.out.println(isVaildBST.isValidBST(tmp));

    }
}
