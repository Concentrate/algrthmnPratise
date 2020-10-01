package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;

import java.util.LinkedList;

/**
 * Created by liudeyu on 2017/7/15.
 */

/**遍历方式*/
public class TreeAllKindOfTraversal {
    private static int INVAILD_NUM = 1 << 20;

    public static void main(String[] argv) {
        int array[] = {INVAILD_NUM, 5, 4, 8, 11, INVAILD_NUM, 13, 4, 7, 2, INVAILD_NUM, INVAILD_NUM, INVAILD_NUM, 1};
        Tree1 tree1 = new Tree1();
        tree1.createTreeFromArray(array);
        tree1.levelTraverseDisplay();
        tree1.iterationPreOrder();
        tree1.levelTraversalAndPrint();
        boolean t = tree1.isAPathGetTheSum(22 );
        System.out.println("exist the path : " + t);


    }
}

class Tree1 {
    Node1 mRoot;
    private static int INVAILD_NUM = 1 << 20;

    public void createTreeFromArray(int[] array) {
        if (array == null) {
            mRoot = null;
            return;
        }
        mRoot = createTreeRecursive(mRoot, array, 1);
    }

    private Node1 createTreeRecursive(Node1 root, int[] array, int start) {
        if (start >= array.length) {
            return root;
        }
        root = array[start] != INVAILD_NUM ? new Node1(array[start]) : null;
        if (root == null) {
            return root;
        }
        int left = start * 2;
        int right = start * 2 + 1;
        if (left < array.length) {
            root.left = createTreeRecursive(root.left, array, start * 2);
        }
        if (right < array.length) {
            root.right = createTreeRecursive(root.right, array, start * 2 + 1);
        }
        return root;
    }

    public void levelTraverseDisplay() {
        System.out.println("level traversal :");
        if (mRoot == null) {
            return;
        }
        LevelTraverseDisplay(mRoot);
    }

    private void LevelTraverseDisplay(Node1 mRoot) {
        LinkedList<Node1> queue = new LinkedList<>();
        queue.offer(mRoot);
        while (!queue.isEmpty()) {
            Node1 top = queue.poll();
            if (top != null) {
                System.out.print(top.value + " ");
                queue.offer(top.left);
                queue.offer(top.right);
            }
        }
        System.out.println("");
    }

    public void iterationPreOrder() {
        if (mRoot == null) {
            return;
        }
        System.out.println("pre order traversal:");
        LinkedList<Node1> stack = new LinkedList<>();
        stack.push(mRoot);
        while (!stack.isEmpty()) {
            Node1 top = stack.pop();
            if (top != null) {
                System.out.print(top.value + " ");
                stack.push(top.right);
                stack.push(top.left);
            }
        }
        System.out.println();
    }
    /*后序非递归和中序非递归，异曲同工，先不写 //todo */

    public void levelTraversalAndPrint() {
        if (mRoot == null) {
            return;
        }
        System.out.println("层次遍历，分层次分行输出:");
        LinkedList<Node1> queue = new LinkedList<>();
        int currentLevelNum = 1, nextLevelNum = 0;
        queue.offer(mRoot);
        while (!queue.isEmpty()) {
            Node1 head = queue.poll();
            currentLevelNum--;
            if (head != null) {
                System.out.print(head.value + " ");
                if (head.left != null) {
                    queue.offer(head.left);
                    nextLevelNum++;
                }
                if (head.right != null) {
                    queue.offer(head.right);
                    nextLevelNum++;
                }
            }
            if (currentLevelNum == 0) {
                System.out.println();
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }
        }
    }


    boolean isAPathGetTheSum(int sum) {
        return recursiveGetTheSum(0, mRoot, sum);
    }

    private boolean recursiveGetTheSum(int sum, Node1 root, int result) {
        if (root == null) {
            return sum == result;
        }
        if (sum == result && root.left == null && root.right == null) {
            return true;
        } else if (sum > result) {
            return false;
        } else if (sum < result) {
            return recursiveGetTheSum(sum + root.value, root.left, result) ||
                    recursiveGetTheSum(sum + root.value, root.right, result);
        } else {
            return false;
        }


    }
}

class Node1 {
    int value;
    Node1 left, right;

    public Node1(int value) {
        this.value = value;
        left = right = null;
    }
}