package com.com.ldy.java.letcodepratise.tree;

import com.com.ldy.java.DataStuctPratise.Tree.TreeNode;
import com.com.ldy.java.Util.ArrayUtils;

import java.util.*;

/**
 * Created by liudeyu on 2020/1/25.
 */
public class PreTraversal {


    void preOrderTreeWithoutRecursive(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(treeNode);
        List<TreeNode> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            result.add(curNode);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }

            if (curNode.left != null) {
                stack.push(curNode.left);
            }


        }
        ArrayUtils.displayTArray(result);
    }


    void printInOrderWithoutRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> result = new ArrayList<>();
        TreeNode curVisNode = treeNode;

        while (!stack.isEmpty() || curVisNode != null) {
            if (curVisNode != null) {
                stack.push(curVisNode);
                curVisNode = curVisNode.left;
            } else {
                curVisNode = stack.pop();
                result.add(curVisNode);
                curVisNode = curVisNode.right;
            }
        }
        ArrayUtils.displayTArray(result);
    }


    void printInOrderRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printInOrderRecursive(treeNode.left);
        System.out.print(treeNode.val + " ");
        printInOrderRecursive(treeNode.right);
    }

    void printPreOrderWithRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode + " ");
        printPreOrderWithRecursive(treeNode.left);
        printPreOrderWithRecursive(treeNode.right);
    }

    void printPostOrderWithRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printPreOrderWithRecursive(treeNode.left);
        printPreOrderWithRecursive(treeNode.right);
        System.out.print(treeNode + " ");
    }


    void printLevelTravel(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        int childCount = 0;
        int curLevelCount = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            curLevelCount--;
            System.out.print(current + " ");

            if (current.left != null) {
                queue.offer(current.left);
                childCount++;
            }

            if (current.right != null) {
                queue.offer(current.right);
                childCount++;
            }
            if (curLevelCount == 0) {
                System.out.println();
                curLevelCount = childCount;
                childCount = 0;
            }
        }
    }

    public static void main(String[] argv) {
        TreeNode<Integer> treeNode = TreeNode.getBSTRoundbin(10);

//        treeNode.printTreeStruct();
        PreTraversal pro = new PreTraversal();
//        pro.printPreOrderWithRecursive(treeNode);
//        System.out.println();
//        pro.preOrderTreeWithoutRecursive(treeNode);

        pro.printInOrderRecursive(treeNode);
        System.out.println();
        pro.printInOrderWithoutRecursive(treeNode);


        treeNode.printTreeStruct();

        pro.printLevelTravel(treeNode);

    }
}
