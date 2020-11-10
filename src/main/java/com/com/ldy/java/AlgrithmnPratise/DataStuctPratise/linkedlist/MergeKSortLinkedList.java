package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node;

/**
 * @author: liudeyu
 * @date: 2020/11/10
 */
public class MergeKSortLinkedList {


    public Node mergeKLinkedList(Node[] kList) {
        if (kList == null || kList.length == 0) {
            return null;
        }
        return toImpleMergeKLinkedList(kList, 0, kList.length - 1);
    }

    private Node toImpleMergeKLinkedList(Node[] kList, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return kList[rightIndex];
        }
        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        Node leftMerge = toImpleMergeKLinkedList(kList, leftIndex, mid);
        Node rightMerge = toImpleMergeKLinkedList(kList, mid + 1, rightIndex);

        Node head = null;
        Node tmpHead = null;
        while (leftMerge != null && rightMerge != null) {
            if (leftMerge.getVal() < rightMerge.getVal()) {
                if (head == null) {
                    head = leftMerge;
                    tmpHead = head;
                } else {
                    tmpHead.setNext(leftMerge);
                    tmpHead = tmpHead.getNext();
                }
                leftMerge = leftMerge.getNext();
            } else {
                if (head == null) {
                    head = rightMerge;
                    tmpHead = head;
                } else {
                    tmpHead.setNext(rightMerge);
                    tmpHead = tmpHead.getNext();
                }
                rightMerge = rightMerge.getNext();
            }
        }
        if (head == null) {
            return head;
        }

        while (leftMerge != null) {
            tmpHead.setNext(leftMerge);
            leftMerge = leftMerge.getNext();
            tmpHead = tmpHead.getNext();
        }
        while (rightMerge != null) {
            tmpHead.setNext(rightMerge);
            rightMerge = rightMerge.getNext();
            tmpHead = tmpHead.getNext();
        }
        return head;

    }

    public static void main(String[] args) {

        int totalCount = 10;
        Node[] array = new Node[totalCount];
        for (int i = 0; i < array.length; i++) {
            array[i] = NodeUtils.createRandomeIntList(i + 3, false);
            NodeUtils.pringNodeList(array[i]);
        }
        MergeKSortLinkedList mergeKSortLinkedList = new MergeKSortLinkedList();
        Node mergeReslt = mergeKSortLinkedList.mergeKLinkedList(array);
        NodeUtils.pringNodeList(mergeReslt);
    }
}
