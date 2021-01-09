package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.IntegerTreeNode;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.TreeUtils;

/**
 * Created by liudeyu on 2020/1/28.
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;


    @Override
    public String toString() {
        return String.valueOf(val);
    }


    public boolean isValueEqual(TreeNode treeNode) {
        return toString().equals(String.valueOf(treeNode));
    }

    public TreeNode() {
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeNode)) {
            return false;
        }
        return val == ((TreeNode) obj).val;
    }



    public TreeNode(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public TreeNode setVal(Integer val) {
        this.val = val;
        return this;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

    public static TreeNode getBSTRoundbin(int count) {

        TreeNode head = null;
        head = toImplementInsertNodeMid(1, count, head);
        System.out.println("tree struct is :");
        TreeUtils.printTree(head);
        System.out.println("========end=======");
        return head;

    }

    private static TreeNode toImplementInsertNodeMid(int start, int end, TreeNode head) {
        if (end - start <= 1) {
            head = insertValue(start, head);
            head = insertValue(end, head);
            return head;
        }
        int mid = (int) Math.ceil((start + end) / 2.0f);
        head = insertValue(mid, head);
        toImplementInsertNodeMid(start, mid - 1, head);
        toImplementInsertNodeMid(mid, end, head);
        return head;
    }


    public static TreeNode insertValue(int tmp, TreeNode head) {
        if (head == null) {
            head = new TreeNode();
            head.val = tmp;
            head.left = null;
            head.right = null;
            return head;
        }
        if (head.val < tmp) {
            head.right = insertValue(tmp, head.right);
        } else if (head.val > tmp) {
            head.left = insertValue(tmp, head.left);
        }
        return head;
    }


    public void printTreeStruct() {
        TreeUtils.printTree(this);
    }


    private com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.generalTreeNode.TreeNode<Integer> convertToNormalTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.generalTreeNode.TreeNode<Integer> root = new com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.generalTreeNode.TreeNode<Integer>()
                .setVal(treeNode.val);
        root.setLeft(convertToNormalTreeNode(treeNode.left));
        root.setRight(convertToNormalTreeNode(treeNode.right));
        return root;
    }

}
