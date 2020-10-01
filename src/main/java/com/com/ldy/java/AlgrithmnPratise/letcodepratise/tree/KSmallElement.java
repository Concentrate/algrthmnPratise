package com.com.ldy.java.AlgrithmnPratise.letcodepratise.tree;

import com.com.ldy.java.AlgrithmnPratise.letcodepratise.pojo.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Created by liudeyu on 2020/1/30.
 */


/**第k小的节点*/
public class KSmallElement {


    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return 0;
        }
        TreeSet<TreeNode> heap = new TreeSet<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.val - o1.val;
            }
        });
        travelRoot(root, heap, k);

        return heap.first().val;
    }

    private void travelRoot(TreeNode root, TreeSet<TreeNode> heap, int k) {
        if (root == null) {
            return;
        }
        if (heap.size() < k) {
            heap.add(root);
        } else if (heap.size() >= k && root.val < heap.first().val) {
            heap.remove(heap.first());
            heap.add(root);
        }
        travelRoot(root.left, heap, k);
        travelRoot(root.right, heap, k);
    }

    public static void main(String[] argv) {

        KSmallElement smallElement = new KSmallElement();
        TreeNode treeNode = new TreeNode(3).setLeft(new TreeNode(1).setRight(new TreeNode(2)))
                .setRight(new TreeNode(4));
        System.out.println(smallElement.kthSmallest(treeNode, 1));

        Queue<Integer> queue = new PriorityQueue<Integer>();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    }
}
