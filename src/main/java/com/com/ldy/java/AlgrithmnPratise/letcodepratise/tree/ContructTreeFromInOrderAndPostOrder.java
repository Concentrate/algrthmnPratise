package com.com.ldy.java.AlgrithmnPratise.letcodepratise.tree;

/**
 * Created by liudeyu on 2020/1/28.
 */

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.IntegerTreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 中序后序遍历，构建二叉树
 */
public class ContructTreeFromInOrderAndPostOrder {


    private Map<Integer, Integer> inOrderPosMap;
    private Map<Integer, Integer> postOrderPosMap;

    private void initPosMap(int[] inorder, int[] postorder) {
        inOrderPosMap = new HashMap<>();
        postOrderPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderPosMap.put(inorder[i], i);
        }
        for (int j = 0; j < postorder.length; j++) {
            postOrderPosMap.put(postorder[j], j);
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        initPosMap(inorder, postorder);
        return toConstructTreeNode(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }


    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return toBuildTree(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);
    }

    private TreeNode toBuildTree(int iStart, int iEnd, int[] inorder, int pStart, int pEnd, int[] postorder) {
        if (iStart > iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        int midPos = iStart;
        while (midPos <= iEnd && inorder[midPos] != root.val) midPos++;
        int leftTreeNum = midPos - iStart;
        root.left = toBuildTree(iStart, midPos - 1, inorder, pStart, pStart + leftTreeNum - 1, postorder);
        root.right = toBuildTree(midPos + 1, iEnd, inorder, pStart + leftTreeNum, pEnd - 1, postorder);

        return root;

    }


    private TreeNode toConstructTreeNode(int[] inorder, int[] postOrder, int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart >= iEnd) {
            return new TreeNode(inorder[iStart]);
        }
        int laseEle = findTheLastEleInPostOrderArray(inorder, iStart, iEnd);
        int posInMid = findIndexInArray(inorder, laseEle, iStart, iEnd, false);
        int postIndex = findIndexInArray(postOrder, laseEle, pStart, pEnd, true);
        TreeNode root = new TreeNode(laseEle);
        if (iStart <= posInMid - 1) {
            root.left = toConstructTreeNode(inorder, postOrder, iStart, posInMid - 1, pStart, postIndex - 1);
        }
        if (posInMid + 1 <= iEnd) {
            root.right = toConstructTreeNode(inorder, postOrder, Math.min(posInMid + 1, iEnd), iEnd, pStart, postIndex - 1);
        }
        return root;
    }

    private int findIndexInArray(int[] inorder, int laseEle, int fromIndex, int endIndex, boolean isReverFind) {
        if (!isReverFind) {
            for (int i = fromIndex; i <= endIndex; i++) {
                if (laseEle == inorder[i]) {
                    return i;
                }
            }
        } else {
            for (int i = endIndex; i >= fromIndex; i--) {
                if (laseEle == inorder[i]) {
                    return i;
                }
            }
        }
        return 0;
    }

    private int findTheLastEleInPostOrderArray(int[] inorder, int start, int end) {
        int maxIndex = 0;
        int ele = 0;
        int index = start;
        while (index <= end) {
            if (postOrderPosMap.get(inorder[index]) > maxIndex) {
                maxIndex = postOrderPosMap.get(inorder[index]);
                ele = inorder[index];
            }
            index++;
        }
        return ele;
    }


    public static void main(String[] argv) {
        ContructTreeFromInOrderAndPostOrder pro = new ContructTreeFromInOrderAndPostOrder();
        TreeNode treeNode = pro.buildTree2(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

        treeNode.printTreeStruct();
    }
}
