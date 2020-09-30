package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist;

import java.util.*;

/**
 * Created by liudeyu on 2019/11/15.
 */

/**
 * removed repeated node,without order
 */

public class RemoveRepeatedNode<T> {


    public class RecordRepeateNode<T> {
        Node<T> last;
        Node<T> current;

        public RecordRepeateNode(Node<T> last, Node<T> current) {
            this.last = last;
            this.current = current;
        }
    }

    Map<Integer, List<RecordRepeateNode<Integer>>> recordEveryRepeatedOne = new HashMap<>();


    Node<Integer> createRandomRepeatedNode(int length) {
        Random random = new Random();
        Node<Integer> head = new Node<Integer>(-1);
        Node tmp = head;
        List<Integer> sortedTmpArray = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            int bound = random.nextInt(10);
            if (bound < 3) {
                sortedTmpArray.add(i - 1);
            } else {
                sortedTmpArray.add(i);
            }
        }
//        Collections.shuffle(sortedTmpArray);

        int index = 0;
        while (index < length) {
            tmp.next = new Node(sortedTmpArray.get(index));
            tmp = tmp.next;
            index++;
        }
        return head;
    }


    Map<Integer, Integer> recordNodes = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    /**
     * correct
     */
    Node<Integer> recordRepeatedNodeTimes(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        recordNodes.clear();
        Node<Integer> tmp = head;
        while (tmp != null) {

            if (!recordNodes.containsKey(tmp.value)) {
                recordNodes.put(tmp.value, 1);
            } else {
                recordNodes.put(tmp.value, recordNodes.get(tmp.value) + 1);
            }
            tmp = tmp.next;
        }
        tmp = head.next;
        Node last = head;
        Node current = head.next;
        while (current != null) {
            if (recordNodes.get(current.value) > 1) {
                last.next = current.next;
                current = current.next;
                continue;
            }
            last = current;
            current = current.next;
        }
        return head;
    }


    /**
     * not right,@Deprecated
     */
    @Deprecated
    Node<Integer> removeRepeatedNode(Node<Integer> head) {
        recordEveryRepeatedOne.clear();
        Node<Integer> tmp = head.next;
        Node<Integer> last = head;
        while (tmp != null) {
            if (!recordEveryRepeatedOne.containsKey(tmp.value)) {
                List<RecordRepeateNode<Integer>> recoredList = new LinkedList<>();
                recoredList.add(new RecordRepeateNode<Integer>(last, tmp));
                recordEveryRepeatedOne.put(tmp.value, recoredList);
            } else {
                List<RecordRepeateNode<Integer>> recoredList = recordEveryRepeatedOne.get(tmp.value);
                recoredList.add(new RecordRepeateNode<>(last, tmp));
            }
            last = tmp;
            tmp = tmp.next;
        }

        for (int a1 : recordEveryRepeatedOne.keySet()) {
            List<RecordRepeateNode<Integer>> bReList = recordEveryRepeatedOne.get(a1);
            if (bReList != null && bReList.size() > 1) {
                bReList.forEach(integerRecordRepeateNode -> {
                    Node cLast = integerRecordRepeateNode.last;
                    Node cCurr = integerRecordRepeateNode.current;
                    if (cLast != null) {
                        cLast.next = (cCurr != null) ? cCurr.next : cCurr;
                    }
                });
            }
        }

        return head;
    }


    void outputNodeList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        outputNodeList(head.next);
    }


    public static void main(String[] argv) {

        RemoveRepeatedNode<Integer> removeRepeatedMethod = new RemoveRepeatedNode<>();
        Node head = removeRepeatedMethod.createRandomRepeatedNode(40);
        removeRepeatedMethod.outputNodeList(head);
        System.out.println();
        head = removeRepeatedMethod.recordRepeatedNodeTimes(head);
        removeRepeatedMethod.outputNodeList(head);

    }
}
