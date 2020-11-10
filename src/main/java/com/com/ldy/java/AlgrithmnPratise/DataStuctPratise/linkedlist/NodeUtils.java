package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist;

import java.util.Random;

/**
 * Created by liudeyu on 2019/11/15.
 */
public class NodeUtils {


    public static Node<Integer> createRandomeList(int count, boolean isRandom) {
        Node head = null;
        Node tmp = null;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            if (head == null) {
                head = new Node(isRandom ? random.nextInt(count) : i);
                tmp = head;
                continue;
            } else {
                tmp.next = new Node(isRandom ? random.nextInt(count) : i);
            }
            tmp = tmp.next;
        }

        return head;
    }

    public static com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node createRandomeIntList(int count, boolean isRandom) {
        Node<Integer> list = createRandomeList(count, isRandom);
        com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node head = null;
        com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node tmpNext = null;
        while (list != null) {
            if (head == null) {
                head = new com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node();
                head.setVal(list.value);
                tmpNext = head;
            } else {
                com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node tmp2 = new com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node();
                tmp2.setVal(list.value);
                tmpNext.setNext(tmp2);
                tmpNext = tmpNext.getNext();
            }

            list = list.next;
        }
        return head;
    }

    public static void pringNodeList(com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node head) {
        if (head == null) {
            return;
        }
        com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getVal() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public static void pringNodeList(Node head) {
        if (head == null) {
            return;
        }
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }


    public static <T> ReverseNode constructReversNode(Node<T> list) {
        if (list == null) {
            return null;
        }
        ReverseNode head = null;
        while (list != null) {
            if (head == null) {
                head = new ReverseNode();
                head.before = null;
                head.cur = list;
                list = list.next;
                continue;
            }
            ReverseNode tmp = new ReverseNode();
            tmp.cur = list;
            tmp.before = head;
            list = list.next;
            head = tmp;

        }


        return head;
    }
}
