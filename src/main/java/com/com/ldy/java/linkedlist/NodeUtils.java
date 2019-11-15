package com.com.ldy.java.linkedlist;

/**
 * Created by liudeyu on 2019/11/15.
 */
public class NodeUtils {


    static Node<Integer> createRandomeList(int count) {
        Node head=new Node(-1);
        Node tmp =head;
        for(int i=0;i<count;i++){
            tmp.next=new Node(i);
            tmp=tmp.next;
        }

        return head;
    }

    static void pringNodeList(Node head){
        if(head==null){
            return;
        }
        Node tmp=head;
        while (tmp!=null){
            System.out.print(tmp.value+" ");
            tmp=tmp.next;
        }
        System.out.println();
    }
}
