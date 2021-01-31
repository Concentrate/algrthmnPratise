package com.com.ldy.java.AlgrithmnPratise.soul;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.list.LinkedListNode;

public class LinkedListReverse {


    public static class Node {
        Node next;
        int val;

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }

        public Node() {
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        public int getVal() {
            return val;
        }

        public Node setVal(int val) {
            this.val = val;
            return this;
        }
    }

    public Node reverList(Node head) {

        if (head == null||head.next==null) {
            return head;
        }

        Node reverNext = reverList(head.next);

        Node tmp = reverNext;
        Node preTmp = reverNext;

        while (tmp != null) {
            preTmp = tmp;
            tmp=tmp.next;
        }
        if(preTmp!=null) {
            preTmp.next = head;
            head.next = null;
        }
        return reverNext;

    }


    public static void displayLinkedList(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.val+"  ");
        displayLinkedList(node.next);
    }

    public static void main(String[] args) {

        Node head = new Node().setVal(1).setNext(new Node().setVal(2).setNext(new Node().setVal(3).setNext(new Node().setVal(4).setNext(
                new Node().setVal(5)
        ))));
        
        LinkedListReverse linkedListNode = new LinkedListReverse();
        displayLinkedList(head);
        System.out.println();
        Node reverHead = linkedListNode.reverList(head);
        displayLinkedList(reverHead);
        System.out.println();


    }

}
