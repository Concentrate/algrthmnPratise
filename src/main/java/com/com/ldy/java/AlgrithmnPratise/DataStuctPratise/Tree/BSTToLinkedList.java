package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.list.LinkedListNode;
import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.list.LinkedListNodeUtils;

/**
 * Created by liudeyu on 2019/12/2.
 */
public class BSTToLinkedList {


    LinkedListNode<TreeNode> convertTreeToLinkedList(TreeNode<Integer> bst) {
        LinkedListNode<TreeNode> head = toConstructLinkedList(bst);
        return head;
    }


    LinkedListNode<TreeNode> convertToList(TreeNode<Integer> bst) {

        if (bst == null) {
            return null;
        }
        LinkedListNode<TreeNode> linkedListNode = new LinkedListNode<>();
        linkedListNode.node = bst;
        LinkedListNode<TreeNode> leftList = convertTreeToLinkedList(bst.left);
        LinkedListNode<TreeNode> rightList = convertTreeToLinkedList(bst.right);
        linkedListNode.before = leftList;
        linkedListNode.next = rightList;
       // 牛批

        if (leftList != null) {
            LinkedListNode tmp = leftList;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = linkedListNode;
        }
        if (rightList != null) {
            rightList.before = linkedListNode;
        }

        LinkedListNode head = leftList;
        if (head == null) {
            head = linkedListNode;
        }

        return head;

    }

    LinkedListNode<TreeNode> toConstructLinkedList(TreeNode<Integer> bst) {
        if (bst == null) {
            return null;
        }

        LinkedListNode<TreeNode> beforeNode = toConstructLinkedList(bst.left);
        LinkedListNode tmpLeftEnd = beforeNode;
        while (tmpLeftEnd != null && tmpLeftEnd.next != null) {
            tmpLeftEnd = tmpLeftEnd.next;
        }

        LinkedListNode<TreeNode> currNode = new LinkedListNode<>();
        currNode.node = bst;
        currNode.before = tmpLeftEnd;
        if (tmpLeftEnd != null) {
            tmpLeftEnd.next = currNode;
        }
        LinkedListNode<TreeNode> rightNode = toConstructLinkedList(bst.right);
        currNode.next = rightNode;
        if (rightNode != null) {
            rightNode.before = currNode;
        }

        LinkedListNode head = null;
        if (beforeNode != null) {
            head = beforeNode;
        } else if (currNode != null) {
            head = currNode;
        }
        return head;

    }


    public static void main(String[] argv) {

        BSTToLinkedList bstToLinkedList = new BSTToLinkedList();
        TreeNode bstTree = TreeNode.getBSTRoundbin(30);
        LinkedListNode<TreeNode> linkedListNode = bstToLinkedList.convertTreeToLinkedList(bstTree);
        LinkedListNodeUtils.printList(linkedListNode, "<->");
        TreeNode bst2 = TreeNode.getBSTRoundbin(32);
        LinkedListNodeUtils.printList(bstToLinkedList.convertToList(bst2), "<->");

    }

}
