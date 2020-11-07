package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode;

public class NodeUtils {


    public static void printNode(Node node) {
        if (node == null) {
            System.out.println();
            return;
        }
        System.out.print(node.val + " ");
        printNode(node.getNext());
    }
}
