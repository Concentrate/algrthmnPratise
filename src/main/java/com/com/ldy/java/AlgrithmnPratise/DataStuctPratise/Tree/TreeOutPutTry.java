package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.IntegerTreeNode.TreeNode;
import com.com.ldy.java.AlgrithmnPratise.utils.ListUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeOutPutTry {

    public static void main(String[] args) {
        TreeOutPutTry outPutTry = new TreeOutPutTry();
        TreeNode treeNode = new TreeNode(1).setLeft(null).setRight(new TreeNode(2).setLeft(new TreeNode(3)));
        List<Integer> output = outPutTry.preorderTraversal(treeNode);
        ListUtils.printList(output, 0);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList();
        toImplePreNotRecur(root, res);
        return res;
    }

    public void toImplePreOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        toImplePreOrder(root.left, res);
        toImplePreOrder(root.right, res);
    }

    public void toImplePreNotRecur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();

//        res.add(root.val);
        stack.push(root);
        TreeNode tmp = root;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }

        }


    }

    public void toImplePostNotRecur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
//        res.add(root.val);
        stack.push(root);
        TreeNode tmp = root;
        while (!stack.isEmpty()) {
            tmp=stack.pop();

            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }

        }
    }

}
