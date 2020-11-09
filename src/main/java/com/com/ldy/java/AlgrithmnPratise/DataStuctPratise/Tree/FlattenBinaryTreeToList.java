package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;


import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.inttreenode.TreeNode;
import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node;
import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.NodeUtils;

/**
 * 给定一个二叉树，原地将它展开为链表。
 */
public class FlattenBinaryTreeToList {


    Node flatternBinaryTree(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        Node headNode = flatternBinaryTree(treeNode.left);
        Node tmp = headNode;
        while (tmp != null && tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        Node curHead = new Node();
        curHead.setVal(treeNode.getVal());
        curHead.setNext(flatternBinaryTree(treeNode.right));
        if (tmp == null) {
            return curHead;
        } else {
            tmp.setNext(curHead);
            return headNode;
        }
    }

    public static void main(String[] args) {

        FlattenBinaryTreeToList flattenBinaryTreeToList = new FlattenBinaryTreeToList();
        TreeNode treeNode = TreeNode.getBSTRoundbin(30);
        treeNode.printTreeStruct();
        NodeUtils.printNode(flattenBinaryTreeToList.flatternBinaryTree(treeNode));
    }
}
