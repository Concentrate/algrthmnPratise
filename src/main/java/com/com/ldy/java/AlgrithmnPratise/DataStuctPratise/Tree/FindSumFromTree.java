package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;

/**
 * Created by liudeyu on 2019/12/2.
 */

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.generalTreeNode.TreeNode;
import com.com.ldy.java.common.CollectionUtil;

import java.util.*;

/**
 * from root to leaf ,find a sum to accord to requirement
 */
public class FindSumFromTree {

    Set<List<Integer>> resultSet = new HashSet<>();

    public Set<List<Integer>> findSumFromTree(TreeNode<Integer> treeNode, int sum) {
        resultSet.clear();
        System.out.println("find sum to " + sum);
        recursiveFindSum(treeNode, sum, 0, new ArrayList<>());
        System.out.println("end======");
        return resultSet;

    }

    private void recursiveFindSum(TreeNode<Integer> treeNode, int target, int tmpSum, List<Integer> recordValues) {
        if (treeNode == null) {
            return;
        }
        tmpSum += treeNode.val;
        if (tmpSum == target) {
            recordValues.add(treeNode.val);
            resultSet.add(recordValues);
        } else if (tmpSum < target) {
            recordValues.add(treeNode.val);
            List<Integer> tmpCopy = CollectionUtil.copyList(recordValues);
            recursiveFindSum(treeNode.left, target, tmpSum, tmpCopy);
            tmpCopy = CollectionUtil.copyList(recordValues);
            recursiveFindSum(treeNode.right, target, tmpSum, tmpCopy);
        }
    }

    void printAllPossibleSum(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print("print all possible sum =====");
        toImplementPrintAllSumTreeNode(treeNode, 0);
        System.out.println("end==========");
    }

    private void toImplementPrintAllSumTreeNode(TreeNode<Integer> treeNode, int tmpSum) {
        if (treeNode == null) {
            return;
        }
        tmpSum += treeNode.val;
        System.out.print(tmpSum + "   ");
        toImplementPrintAllSumTreeNode(treeNode.left, tmpSum);
        toImplementPrintAllSumTreeNode(treeNode.right, tmpSum);
    }


    public static void main(String[] argv) {
        FindSumFromTree findSumFromTree = new FindSumFromTree();
        TreeNode tmpTree = TreeNode.getBSTRoundbin(100);
        findSumFromTree.printAllPossibleSum(tmpTree);
        Set<List<Integer>> set = findSumFromTree.findSumFromTree(tmpTree, 590);
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            List<Integer> tmpList = iterator.next();
            for (int a1 : tmpList) {
                System.out.print(a1 + "  ");
            }
            System.out.println();
        }

    }
}
