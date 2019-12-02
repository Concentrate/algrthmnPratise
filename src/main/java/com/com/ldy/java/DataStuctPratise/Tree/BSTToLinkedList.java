package com.com.ldy.java.DataStuctPratise.Tree;

import com.com.ldy.java.DataStuctPratise.list.LinkedListNode;
import com.com.ldy.java.DataStuctPratise.list.LinkedListNodeUtils;

/**
 * Created by liudeyu on 2019/12/2.
 */
public class BSTToLinkedList {


    LinkedListNode<TreeNode> convertTreeToLinkedList(TreeNode<Integer> bst) {
        LinkedListNode<TreeNode> head = toConstructLinkedList(bst);
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
        LinkedListNode<TreeNode> linkedListNode = bstToLinkedList.convertTreeToLinkedList(TreeNode.getBSTRoundbin(30));
        LinkedListNodeUtils.printList(linkedListNode, "<->");

    }

}
