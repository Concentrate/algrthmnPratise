package com.com.ldy.java.letcodepratise.tree;

/**
 * Created by liudeyu on 2020/1/28.
 */

import com.com.ldy.java.letcodepratise.pojo.TreeNode;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * question @link https://leetcode-cn.com/problems/symmetric-tree/,判断二叉树是否是镜像二叉树，左右子树长得一样
 */
public class SymmetricTreePro {


    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }
        final int TAG_VALUE = -0x983283;
        TreeNode tmpNulNode = new TreeNode(TAG_VALUE);
        tmpNulNode.val = TAG_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        int childCount = 0, curLevelCount = 1;
        List<String> checkSymArr = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevelCount--;
            if (cur.val == TAG_VALUE) {
                checkSymArr.add("null");
            } else {
                checkSymArr.add(String.valueOf(cur.val));
                if (cur.left != null) {
                    queue.offer(cur.left);
                } else {
                    queue.offer(tmpNulNode);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                } else {
                    queue.offer(tmpNulNode);
                }
                childCount = childCount + 2;
            }
            if (curLevelCount == 0) {
                curLevelCount = childCount;
                childCount = 0;
                boolean checkIsOk = checkIsVailed(checkSymArr);
                checkSymArr.clear();
                if (!checkIsOk) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean checkIsVailed(List<String> checkSymArr) {
        if (checkSymArr == null || checkSymArr.isEmpty()) {
            return true;
        }
        boolean check = true;
        int arrLen = checkSymArr.size();
        for (int i = 0; i < Math.ceil(arrLen / 2); i++) {
            if (!checkSymArr.get(i).equals(checkSymArr.get(arrLen - 1 - i))) {
                check = false;
                break;
            }
        }
        return check;
    }

    public boolean isSymRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return toImpleSysRecursive(root.left, root.right);
    }

    private boolean toImpleSysRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return toImpleSysRecursive(left.left, right.right) && toImpleSysRecursive(left.right, right.left);
    }

    public static void main(String[] argv) {
        SymmetricTreePro pro = new SymmetricTreePro();
        TreeNode root = new TreeNode().setVal(1)
                .setLeft(new TreeNode().setVal(2).setLeft(new TreeNode(2)))
                .setRight(new TreeNode().setVal(2).setRight(new TreeNode(2)));
        System.out.println(pro.isSymmetric(root));
        System.out.println(pro.isSymRecursive(root));

    }
}
