package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.list;

/**
 * Created by liudeyu on 2019/12/2.
 */
public class LinkedListNodeUtils {


    public static <T> void printList(LinkedListNode<T> listNode,String sep) {
        if (listNode == null) {
            return;
        }
        LinkedListNode tmp = listNode;
        while (tmp != null) {
            System.out.print(tmp.node + sep);
            tmp = tmp.next;
        }
        System.out.println("end");
    }
}
