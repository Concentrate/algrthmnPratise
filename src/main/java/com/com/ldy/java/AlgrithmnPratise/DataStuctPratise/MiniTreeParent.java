package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise;

import apple.laf.JRSUIUtils;
import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.inttreenode.TreeNode;

/**
 * @author: liudeyu
 * @date: 2021/2/3
 */
public class MiniTreeParent {

    public TreeNode findMinParent(TreeNode root, TreeNode first, TreeNode second) {

        if (root == null) {
            return root;
        }
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }


        if (root == first || root == second) {
            return root;
        }


        TreeNode leftFind = findMinParent(root.left, first, second);
        TreeNode rightFind = findMinParent(root.right, first, second);
        if (leftFind != null && rightFind != null) {
            return root;
        } else if (leftFind != null) {
            return leftFind;
        } else {
            return rightFind;
        }

    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        TreeNode thirdTreeNode = new TreeNode(3);
        TreeNode sevenNode = new TreeNode(7);
        TreeNode second = new TreeNode(2);
        TreeNode five = new TreeNode(5);

        root.setLeft(second.setLeft(new TreeNode(4)).setRight(five))
                .setRight(thirdTreeNode.setLeft(new TreeNode(6)).setRight(sevenNode));

        MiniTreeParent miniTreeParent = new MiniTreeParent();
        System.out.println(miniTreeParent.findMinParent(root, sevenNode, five));


    }
}
