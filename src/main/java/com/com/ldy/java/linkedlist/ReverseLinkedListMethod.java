package com.com.ldy.java.linkedlist;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by liudeyu on 2019/11/15.
 */

/** 翻转链表，递归非递归*/
public class ReverseLinkedListMethod {


    Node<Integer> reverseNodeListRecursive(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> interValue = reverseNodeListRecursive(head.next);
        Node<Integer> lastNode = interValue;
        while (lastNode != null && lastNode.next != null) {
            lastNode = lastNode.next;
        }
        if (lastNode != null) {
            lastNode.next = head;
            head.next = null;
        } else {
            return head;
        }
        return interValue;
    }


    Node<Integer> withoutRecursiveReverse(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> preCur = head, endCur = null;
        Node<Integer> dector = head;
        while (preCur.next!=endCur) {
            while (dector.next != endCur) {
                dector = dector.next;
            }
            dector.next = preCur;
            dector = preCur.next;
            preCur.next = endCur;
            endCur = preCur;
            preCur=dector;
        }
        return preCur;
    }

    static void printNodeListRe(Node<Integer> head, Function<Node<Integer>,Node<Integer>> function){
        NodeUtils.pringNodeList(head);
        NodeUtils.pringNodeList(function.apply(head));
    }

    public static void main(String[] argv) {
        ReverseLinkedListMethod reverseLinkedListMethod = new ReverseLinkedListMethod();
        Node head = NodeUtils.createRandomeList(20);
        printNodeListRe(head,reverseLinkedListMethod::reverseNodeListRecursive);
        head=NodeUtils.createRandomeList(20);
        printNodeListRe(head,reverseLinkedListMethod::withoutRecursiveReverse);
    }
}
