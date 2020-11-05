package com.com.ldy.java.AlgrithmnPratise.letcodepratise.tree;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.IntegerTreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liudeyu on 2020/1/30.
 */

/**
 * @link https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerialzeTreeAndDerialze {


    // 用层次遍历就能很好构建一棵树


    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount = 1, childChount = 0;
        StringBuilder result = new StringBuilder();

        TreeNode NULL_NODE = new TreeNode(-0x98373083);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.append(current.val + "#");
            if (current.left != null) {
                queue.offer(current.left);
            } else if (current != NULL_NODE) {
                queue.offer(NULL_NODE);
            }
            if (current.right != null) {
                queue.offer(current.right);
            } else if (current != NULL_NODE) {
                queue.offer(NULL_NODE);
            }
        }
        return result.toString();

    }


    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        TreeNode NULL_NODE = new TreeNode(-0x98373083);
        Queue<TreeNode> queue = new LinkedList<>();
        int startIndex = 0;
        TreeNode root = null;

        while (!queue.isEmpty() || startIndex < data.length() - 1) {
            int cSharkSymIndex = data.indexOf("#", startIndex);
            String num = data.substring(startIndex, cSharkSymIndex);
            startIndex = cSharkSymIndex + "#".length();
            int value = Integer.valueOf(num);
            if (root == null) {
                root = new TreeNode(value);
                queue.offer(root);
                continue;
            }
            TreeNode tmpRoot = queue.poll();
            if (value != NULL_NODE.val) {
                tmpRoot.left = new TreeNode(value);
                queue.offer(tmpRoot.left);
            }
            cSharkSymIndex = data.indexOf("#", startIndex);
            num = data.substring(startIndex, cSharkSymIndex);
            startIndex = cSharkSymIndex + "#".length();
            value = Integer.valueOf(num);
            if (value != NULL_NODE.val) {
                tmpRoot.right = new TreeNode(value);
                queue.offer(tmpRoot.right);
            }

        }

        return root;

    }


    public static void main(String[] argv) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.setLeft(new TreeNode(2).setLeft(new TreeNode(3))).setRight(new TreeNode(4));
        treeNode.printTreeStruct();

        SerialzeTreeAndDerialze serialzeTreeAndDerialze = new SerialzeTreeAndDerialze();
        System.out.println(serialzeTreeAndDerialze.serialize(treeNode));
        serialzeTreeAndDerialze.deserialize(serialzeTreeAndDerialze.serialize(treeNode)).printTreeStruct();

    }
}
