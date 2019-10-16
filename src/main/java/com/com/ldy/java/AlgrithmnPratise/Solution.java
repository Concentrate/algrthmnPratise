package com.com.ldy.java.AlgrithmnPratise;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = null, head = null, lastNode = null;
        int value = 0, t = 0;
        while (l1 != null && l2 != null) {
            value = (l1.val + l2.val + t) % 10;
            t = (l1.val + l2.val + t) / 10;
            tmp = new ListNode(value);
            tmp.next = null;
            if (head == null) {
                head = tmp;
            }
            if (lastNode != null) {
                lastNode.next = tmp;
            }
            lastNode = tmp;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
            while (l1 != null) {
                lastNode=l1;
                int atmp=l1.val;
                l1.val = (l1.val + t) % 10;
                t = (atmp + t) / 10;
                if (t == 0) {
                    break;
                }
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            lastNode.next = l2;
            while(l2!=null){
                lastNode=l2;
                int atmp=l2.val;
                l2.val=(l2.val+t)%10;
                t=(atmp+t)/10;
                if(t==0){
                    break;
                }
                l2=l2.next;
            }
        }
        if (t != 0 && l1 == null && l2 == null) {
            ListNode node = new ListNode(t);
            node.next = null;
            lastNode.next = node;
            lastNode = node;
        }
        return head;
    }
    void displayList(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }
        System.out.println("");
    }

    public static void main(String[] argv) {
        ListNode one=new ListNode(9);
        one.next=new ListNode(9);
        ListNode list2=new ListNode(1);
        Solution solution=new Solution();
       ListNode sum= solution.addTwoNumbers(list2,one);
       solution.displayList(sum);

    }
}