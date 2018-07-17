package com.ldy.java.DataStuctPratise;

/**
 * Created by liudeyu on 2017/3/31.
 */
public class BST {
    static class Node<T> {
        T value;
        int processNum;
        Node left;
        Node right;
    }

    Node<Integer> tree;

    void insertElement(int a, int process) {
        tree = toImplementInsert(tree, a, process);
    }

    private Node<Integer> toImplementInsert(Node aTree, int a, int process) {
        if (aTree == null) {
            Node<Integer> atmp = new Node<>();
            atmp.value = a;
            atmp.processNum = process;
            atmp.left = atmp.right = null;
            aTree = atmp;
        }
        if (((Integer) aTree.value) > a) {
            aTree.left = toImplementInsert(aTree.left, a, process);
        } else {
            aTree.right = toImplementInsert(aTree.right, a, process);
        }
        return aTree;
    }


}
