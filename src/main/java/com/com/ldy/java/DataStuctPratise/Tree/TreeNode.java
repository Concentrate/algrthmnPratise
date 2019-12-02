package com.com.ldy.java.DataStuctPratise.Tree;

import java.util.Set;

/**
 * Created by liudeyu on 2019/12/2.
 */
public class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode() {

    }

    public static TreeNode<Integer> getBSTRoundbin(int count) {

        TreeNode<Integer> head = null;
        head = toImplementInsertNodeMid(1, count, head);
        TreeUtils.printTree(head);
        return head;

    }

    private static TreeNode<Integer> toImplementInsertNodeMid(int start, int end, TreeNode<Integer> head) {
        if (end - start <= 1) {
            head = insertValue(start, head);
            head = insertValue(end, head);
            return head;
        }
        int mid = (start + end) / 2;
        head = insertValue(mid, head);
        toImplementInsertNodeMid(start, mid, head);
        toImplementInsertNodeMid(mid, end, head);
        return head;
    }


    public static TreeNode<Integer> insertValue(int tmp, TreeNode<Integer> head) {
        if (head == null || head.value == null) {
            head = new TreeNode<>();
            head.value = tmp;
            head.left = null;
            head.right = null;
            return head;
        }
        if (head.value < tmp) {
            head.right = insertValue(tmp, head.right);
        } else if (head.value > tmp) {
            head.left = insertValue(tmp, head.left);
        }
        return head;
    }


    public static void main(String[] argv) {
        TreeNode.getBSTRoundbin(7);
    }

}
