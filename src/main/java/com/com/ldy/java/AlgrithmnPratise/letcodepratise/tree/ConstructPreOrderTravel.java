package com.com.ldy.java.AlgrithmnPratise.letcodepratise.tree;

import com.com.ldy.java.AlgrithmnPratise.letcodepratise.pojo.TreeNode;

/**
 * Created by liudeyu on 2020/1/30.
 */
public class ConstructPreOrderTravel {

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

    public static void main(String[] argv) {

        ConstructPreOrderTravel preTraversal = new ConstructPreOrderTravel();
        preTraversal.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).printTreeStruct();


    }
}
