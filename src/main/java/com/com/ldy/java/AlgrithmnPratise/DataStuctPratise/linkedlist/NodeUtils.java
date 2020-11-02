package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist;

/**
 * Created by liudeyu on 2019/11/15.
 */
public class NodeUtils {


    public static Node<Integer> createRandomeList(int count) {
        Node head = new Node(-1);
        Node tmp = head;
        for (int i = 0; i < count; i++) {
            tmp.next = new Node(i);
            tmp = tmp.next;
        }

        return head;
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
