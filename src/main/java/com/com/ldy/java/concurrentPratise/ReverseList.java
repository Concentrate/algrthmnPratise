package com.com.ldy.java.concurrentPratise;

public class ReverseList {


    public static class Node {
        int val;
        Node next;


        public int getVal() {
            return val;
        }

        public Node setVal(int val) {
            this.val = val;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }
    }

    /**
     * @param list 原链表
     * @return 返回翻转链表，  翻转链表 的函数 ，返回的是翻转后的 头节点
     * <p>
     * 这里利用了递归的思想，先让 list.next 链表翻转完， 然后把原始的头节点 插到翻转后的 list.next的
     * 结果链表的尾部，这样就完成了整个链表的翻转
     */
    public static Node reverseList(Node list) {

        if (list == null) {
            return list;
        }


        Node reverNext = reverseList(list.next);

        Node toFindEndNode = reverNext;
        Node preverNode = reverNext;
        while (toFindEndNode != null) {
            preverNode = toFindEndNode;
            toFindEndNode = toFindEndNode.next;
        }

        if (preverNode != null) {
            preverNode.next = list;
            list.next = null;
        } else {
            reverNext = list;
        }

        return reverNext;

    }

    public static void printNode(Node list) {
        if (list == null) {
            return;
        }
        System.out.print(list.val + "  ");
        printNode(list.next);
    }

    public static void main(String[] args) {
        Node tmpList = new Node().setVal(1).setNext(new Node().setVal(2).setNext(
                new Node().setVal(3).setNext(new Node().setVal(4))
        ));
        printNode(tmpList);
        System.out.println();
        Node reverList = reverseList(tmpList);
        printNode(reverList);
    }
}
