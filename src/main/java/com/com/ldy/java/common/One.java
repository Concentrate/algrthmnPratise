package com.com.ldy.java.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class One {

    public static class TreeNode {
        int val;
        TreeNode[] children;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode[] getChildren() {
            return children;
        }

        public void setChildren(TreeNode[] children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", children=" + Arrays.toString(children) +
                    '}';
        }
    }

    private String NODE_SPLITE = "##";
    private String NODE_CHILD_NUM_SPLIT = "__";


    public String convertTreeToString(TreeNode root) {
        if (root == null) {
            return "";
        }


        Queue<TreeNode> reverseQueu = new LinkedList<>();
        reverseQueu.offer(root);
        StringBuilder result = new StringBuilder();
        while (!reverseQueu.isEmpty()) {

            TreeNode tmp = reverseQueu.poll();
            appendNode(result, tmp);

            if (tmp.getChildren() == null) {
                continue;
            }

            for (int i = 0; i < tmp.getChildren().length; i++) {
//                appendNode(result,tmp.getChildren()[i]);
                reverseQueu.offer(tmp.getChildren()[i]);
            }

        }

        return result.toString();


    }


    public TreeNode paserStringToTree(String rawString) {
        if (rawString == null || rawString.length() == 0) {
            return null;
        }
        String[] nodeAndLength = rawString.split(NODE_SPLITE);

        Queue<TreeNode> toBuildTree = new LinkedList<>();


        for (int i = 0; i < nodeAndLength.length; i++) {
            String tmpContent = nodeAndLength[i];
            String[] nodeContent = tmpContent.split(NODE_CHILD_NUM_SPLIT);

            int nodeVal = Integer.parseInt(nodeContent[0]);
            int childNum = Integer.parseInt(nodeContent[1]);
            TreeNode treeNode = new TreeNode();
            treeNode.setVal(nodeVal);
            if (childNum > 0) {
                treeNode.setChildren(new TreeNode[childNum]);
            }
            toBuildTree.offer(treeNode);
        }

        TreeNode root = null;
        TreeNode lastOne = null;

        Queue<TreeNode> toReverQueue = new LinkedList<>();
        TreeNode tmp = toBuildTree.poll();
        toReverQueue.offer(tmp);
        root = tmp;
        while (!toReverQueue.isEmpty()) {

            tmp = toReverQueue.poll();
            if (tmp == null || tmp.getChildren() == null) {
                continue;
            }
            if (tmp.getChildren().length > 0) {

                for (int a1 = 0; a1 < tmp.getChildren().length; a1++) {
                    TreeNode aNode = toBuildTree.poll();
                    tmp.getChildren()[a1] = aNode;
                    toReverQueue.offer(aNode);
                }
            }

        }

        return root;


    }

    private void appendNode(StringBuilder result, TreeNode tmp) {
        result.append(tmp.getVal()).append(NODE_CHILD_NUM_SPLIT)
                .append(tmp.getChildren() != null ? tmp.getChildren().length : 0)
                .append(NODE_SPLITE);
    }


    public static void main(String[] args) {


        TreeNode treeNode = new TreeNode(1);
        treeNode.setChildren(new TreeNode[3]);

        for (int i = 0; i < treeNode.getChildren().length; i++) {
            treeNode.getChildren()[i] = new TreeNode(i + 2);
            treeNode.getChildren()[i].setChildren(new TreeNode[3]);
            for (int j = 0; j < 3; j++) {

                treeNode.getChildren()[i].getChildren()[j] = new TreeNode(99);
            }

        }

        One one = new One();
        System.out.println(one.convertTreeToString(treeNode));

        TreeNode reverNode = one.paserStringToTree(one.convertTreeToString(treeNode));
        System.out.println(reverNode);


    }

}
