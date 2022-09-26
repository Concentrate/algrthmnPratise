package com.com.ldy.java.AlgrithmnPratise.leetcodestruct;

public class CircleListNodeJudge {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this;
        }
    }


    public static boolean haveCircle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastStep = head.next;
        ListNode slowStep = head;

        while (fastStep != null && fastStep != slowStep) {

            slowStep = slowStep.next;
            fastStep = fastStep.next;
            if (fastStep != null) {
                fastStep = fastStep.next;
            }
        }
        return  fastStep == slowStep;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1).setNext(new ListNode(2)
                .setNext(new ListNode(3).setNext(new ListNode(4))));

        System.out.println(haveCircle(head));
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }

        end.next = head;
        System.out.println(haveCircle(head));


    }
}
