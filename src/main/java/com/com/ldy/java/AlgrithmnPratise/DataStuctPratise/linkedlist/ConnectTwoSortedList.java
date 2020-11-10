package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist;

/**
 * @author: liudeyu
 * @date: 2020/11/2
 */


/**
 * ## [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
 * <p>
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * #### Example
 * <p>
 * ```text
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * <p>
 * ```
 * <p>
 * #### Solution
 */
public class ConnectTwoSortedList {

    Node<Integer> combineList(Node<Integer> listA, Node<Integer> listB) {
        if (listA == null) {
            return listB;
        }
        if (listB == null) {
            return listA;
        }
        Node<Integer> head = listA.value < listB.value ? listA : listB;

        head.next = head == listA ? combineList(listA.next, listB) : combineList(listA, listB.next);
        return head;

    }

    public static void main(String[] args) {

        Node<Integer> list1 = NodeUtils.createRandomeList(10, true);
        Node<Integer> list2 = NodeUtils.createRandomeList(10, true);

        NodeUtils.pringNodeList(new ConnectTwoSortedList().combineList(list1, list2));
    }
}
