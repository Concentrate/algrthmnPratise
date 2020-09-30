package com.com.ldy.java.AlgrithmnPratise.letcodepratise;

/**
 * Created by liudeyu on 2020/2/27.
 */
public class RotateListPratise {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode setVal(int val) {
            this.val = val;
            return this;
        }


        public ListNode appendTailNext(ListNode next) {
            ListNode tmp = this;
            while (tmp != null && tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = next;
            return this;
        }

        public void displayItSelf() {
            displayNode(this);
            System.out.println();
        }

        private void displayNode(ListNode node) {
            if (node == null) {
                return;
            }
            System.out.print(node.val + " ");
            displayNode(node.next);
        }
    }

    // not done ,还不如用迭代法
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode nextRotate = rotateRight(head.next, k);
        ListNode tmp = nextRotate;
        ListNode beforeLastNull = nextRotate;
        int lengthOfList = 0;
        while (tmp != null) {
            lengthOfList++;
            beforeLastNull = tmp;
            tmp = tmp.next;
        }

        if(lengthOfList>=k){
            head.next=null;
            beforeLastNull.next=head;
        }

        return nextRotate;
    }


    public static void main(String[] argv) {
        RotateListPratise rotateListPratise = new RotateListPratise();
        ListNode head = new ListNode(1).appendTailNext(new ListNode(2)).appendTailNext(new ListNode(3)).appendTailNext(new ListNode(4))
                .appendTailNext(new ListNode(5));
        head.displayItSelf();
        ListNode rotate = rotateListPratise.rotateRight(head, 2);
        rotate.displayItSelf();

    }
}
