package com.com.ldy.java.common;


import com.com.ldy.java.AlgrithmnPratise.leetcodestruct.ListNode;

public class KGroupReverse {

    public static class Solution {

        public ListNode reverList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {

                ListNode tmpNextSave = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmpNextSave;
            }

            return pre;

        }

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k <= 1) {
                return head;
            }

            ListNode resultHead = null;
            //dummy.next=head;
            ListNode cur = head;
            ListNode lastEndGroupPre = null;
            while (cur != null) {

                ListNode start = cur;
                ListNode tmpK = cur;
                for (int i = 0; i < k - 1 && tmpK != null; i++) {
                    tmpK = tmpK.next;
                }
                if (tmpK == null) {
                    break;
                }

                cur = tmpK.next;

                tmpK.next = null;

                ListNode reverKGroup = reverList(start);
                start.next = cur;
                if (lastEndGroupPre != null) {
                    lastEndGroupPre.next = reverKGroup;
                }
                if (resultHead == null) {
                    resultHead = reverKGroup;
                }

                lastEndGroupPre = start;

            }

            if (resultHead == null) {
                resultHead = head;
            }
            return resultHead;

        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1).setNext(new ListNode(2)
                .setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)))));

        Solution solution = new Solution();
        System.out.println(solution.reverseKGroup(listNode, 2));
    }
}
