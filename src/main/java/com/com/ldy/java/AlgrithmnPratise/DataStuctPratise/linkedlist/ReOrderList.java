package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist;

/**
 * @author: liudeyu
 * @date: 2020/11/2
 */

/**
 * 给定一个单链表  L：`L0→L1→…→Ln-1→Ln` ，
 * 将其重新排列后变为： `L0→Ln→L1→Ln-1→L2→Ln-2→…`
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReOrderList {


    Node<Integer> reorderList(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ReverseNode reverseNode = NodeUtils.constructReversNode(head);
        Node<Integer> resultHead = head;
        Node<Integer> resultCur = resultHead;
        while (resultCur != null && reverseNode != null && reverseNode.cur != null) {
            Node tmpNext = resultCur.next;
            Node endNode = reverseNode.cur;
            if (tmpNext != endNode && resultCur != endNode) {
                resultCur.next = endNode;
                endNode.next = tmpNext;
                resultCur = tmpNext;
                reverseNode = reverseNode.before;
            } else {
                resultCur.next = null;
                break;
            }
        }

        return resultHead;
    }

    public static void main(String[] args) {


        Node randomList = NodeUtils.createRandomeList(11, true);
        NodeUtils.pringNodeList(new ReOrderList().reorderList(randomList));

    }

}
