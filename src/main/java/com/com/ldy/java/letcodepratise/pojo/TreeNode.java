package com.com.ldy.java.letcodepratise.pojo;

import com.com.ldy.java.DataStuctPratise.Tree.TreeUtils;

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

    public TreeNode() {
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

    public void printTreeStruct() {
        TreeUtils.printTree(convertToNormalTreeNode(this));
    }

    private com.com.ldy.java.DataStuctPratise.Tree.TreeNode<Integer> convertToNormalTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        com.com.ldy.java.DataStuctPratise.Tree.TreeNode<Integer> root = new com.com.ldy.java.DataStuctPratise.Tree.TreeNode<Integer>()
                .setVal(treeNode.val);
        root.setLeft(convertToNormalTreeNode(treeNode.left));
        root.setRight(convertToNormalTreeNode(treeNode.right));
        return root;
    }

}
