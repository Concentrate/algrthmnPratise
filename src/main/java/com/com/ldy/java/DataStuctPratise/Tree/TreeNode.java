package com.com.ldy.java.DataStuctPratise.Tree;

/**
 * Created by liudeyu on 2019/12/2.
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {

    }

    public T getVal() {
        return val;
    }

    public TreeNode<T> setVal(T val) {
        this.val = val;
        return this;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T>  setLeft(TreeNode<T> left) {
        this.left = left;
        return this;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public TreeNode<T>  setRight(TreeNode<T> right) {
        this.right = right;
        return this;
    }

    public static TreeNode<Integer> getBSTRoundbin(int count) {

        TreeNode<Integer> head = null;
        head = toImplementInsertNodeMid(1, count, head);
        System.out.println("tree struct is :");
        TreeUtils.printTree(head);
        System.out.println("========end=======");
        return head;

    }

    private static TreeNode<Integer> toImplementInsertNodeMid(int start, int end, TreeNode<Integer> head) {
        if (end - start <= 1) {
            head = insertValue(start, head);
            head = insertValue(end, head);
            return head;
        }
        int mid = (int) Math.ceil((start + end) / 2.0f);
        head = insertValue(mid, head);
        toImplementInsertNodeMid(start, mid - 1, head);
        toImplementInsertNodeMid(mid, end, head);
        return head;
    }


    public static TreeNode<Integer> insertValue(int tmp, TreeNode<Integer> head) {
        if (head == null || head.val == null) {
            head = new TreeNode<>();
            head.val = tmp;
            head.left = null;
            head.right = null;
            return head;
        }
        if (head.val < tmp) {
            head.right = insertValue(tmp, head.right);
        } else if (head.val > tmp) {
            head.left = insertValue(tmp, head.left);
        }
        return head;
    }


    public void printTreeStruct() {
        TreeUtils.printTree(this);
    }

    public static void main(String[] argv) {
        TreeNode.getBSTRoundbin(7);
    }

    @Override
    public String toString() {
        return val + "";
    }
}
