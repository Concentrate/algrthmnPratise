package com.com.ldy.java.AlgrithmnPratise.letcodepratise.tree;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.IntegerTreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liudeyu on 2020/1/30.
 *
 * @link https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class TreeCodec {


    /**用先序和中序构造树，没法解决，树中有相同元素问题*/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(preOrderString(root) + "$").append(inOrderString(root));
        return builder.toString();
    }


    public String preOrderString(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(root.val + "#");
        builder.append(preOrderString(root.left));
        builder.append(preOrderString(root.right));
        return builder.toString();
    }

    public String inOrderString(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(inOrderString(root.left));
        builder.append(root.val + "#");
        builder.append(inOrderString(root.right));
        return builder.toString();
    }


    boolean isStringEmpty(String text) {
        return text == null || "".equals(text);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data) || data.indexOf("$") < 0) {
            return null;
        }
        int tmpIn = data.indexOf("$");
        String preStr = data.substring(0, tmpIn);
        String inStr = data.substring(tmpIn + 1);
        String[] preOrder = preStr.split("#");
        String[] inOrder = inStr.split("#");
        int[] preNumOrder = covertToIntArray(preOrder);
        int[] inNumOrder = covertToIntArray(inOrder);

        return buildTree(preNumOrder,inNumOrder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        return toBuildTree(0, inorder.length - 1, inorder, 0, preorder.length - 1, preorder);
    }

    private TreeNode toBuildTree(int iStart, int iEnd, int[] inorder, int pStart, int pEnd, int[] preorder) {
        if (iStart > iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int midPos = iStart;
        while (midPos <= iEnd && inorder[midPos] != root.val) midPos++;
        int leftTreeNum = midPos - iStart;
        root.left = toBuildTree(iStart, midPos - 1, inorder, pStart+1,pStart+leftTreeNum, preorder);
        root.right = toBuildTree(midPos + 1, iEnd, inorder, pStart + leftTreeNum+1, pEnd, preorder);
        return root;
    }

    private int[] covertToIntArray(String[] array) {
        List<Integer> result = new LinkedList<>();
        for (String tmp : array) {
            try {
                result.add(Integer.valueOf(tmp));
            } catch (NumberFormatException ex) {

            }
        }
        int[] bArray = new int[result.size()];
        int index = -1;
        for (int c1 : result) {
            bArray[++index] = c1;
        }
        return bArray;
    }

    public static void main(String[] argv) {

        TreeCodec codec = new TreeCodec();
        TreeNode treeNode = new TreeNode(3);
        treeNode.setLeft(new TreeNode(2).setLeft(new TreeNode(3))).setRight(new TreeNode(4));
        treeNode.printTreeStruct();
        System.out.println(codec.serialize(treeNode));
        codec.deserialize(codec.serialize(treeNode)).printTreeStruct();

    }

}
