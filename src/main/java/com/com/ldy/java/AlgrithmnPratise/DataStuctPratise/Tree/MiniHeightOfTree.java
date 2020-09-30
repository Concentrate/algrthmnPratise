package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;

import java.util.Random;

/**
 * Created by liudeyu on 2017/7/13.
 */
public class MiniHeightOfTree {
    public static void main(String[] argv) {

        Tree tree = new Tree();
        tree.createTreeofN(20);
        tree.displayTreeHeight();
        System.out.println("The minimun height from top to bottom is " + tree.minDistanceToRoot);

    }
}


class Tree {
    Node root;
    Random random = new Random();
    int minDistanceToRoot = Integer.MAX_VALUE;

    public Tree() {
    }

    void createTreeofN(int n) {
        root = toImplementCreateTree(1, n);
    }

    private Node toImplementCreateTree(int i, int maxNum) {
        if (i > maxNum) {
            return null;
        }
        Node a1 = new Node();
        a1.value = i;
        double time=Math.random();
        if (time < 0.3) {
            a1.left = toImplementCreateTree(i + 1, maxNum);
        }else if(time<0.8) {
            a1.right = toImplementCreateTree(i + 1, maxNum);
        }

        return a1;
    }

    void displayTreeHeight() {
        toImplementDisplayTreeHeight(root, 1);
    }

    private void toImplementDisplayTreeHeight(Node root, int i) {
        if (root != null && root.left == null && root.right == null) {
            System.out.print(root.value + " 's height is " + i + "\n");
            if (i < minDistanceToRoot) {
                minDistanceToRoot = i;
            }
            return;
        }
        if (root != null && root.left != null) {
            toImplementDisplayTreeHeight(root.left, i + 1);
        }
        if (root != null && root.right != null) {
            toImplementDisplayTreeHeight(root.right, i + 1);
        }
    }


}

class Node {
    int value;
    Node left, right;
}
