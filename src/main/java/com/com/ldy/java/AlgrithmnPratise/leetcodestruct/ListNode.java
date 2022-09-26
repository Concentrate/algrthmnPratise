package com.com.ldy.java.AlgrithmnPratise.leetcodestruct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }


    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
