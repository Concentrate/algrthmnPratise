package com.com.ldy.java.AlgrithmnPratise.letcodepratise.tree;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree.TreeUtils;
import com.com.ldy.java.AlgrithmnPratise.letcodepratise.pojo.TreeNode;

import java.util.*;

/**
 * Created by liudeyu on 2020/1/30.
 *
 * @link https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 最深公共子节点
 */
public class FindDeepCommonParent {


    /**
     * not right
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        List<TreeNode> pFindList = new LinkedList<>();
        List<TreeNode> qFindList = new LinkedList<>();


        return getCommonTreeNode(travalList(pFindList, root, p), travalList(qFindList, root, q));

    }

    private List<TreeNode> travalList(List<TreeNode> treeNodes, TreeNode root, TreeNode targetNode) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            treeNodes.add(tmpNode);
            if (tmpNode.val == targetNode.val) {
                break;
            } else if (tmpNode.left == null && tmpNode.right == null) {
                treeNodes.remove(tmpNode);
                removeFromEndExcept(treeNodes, root);
            }
            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }

            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
        }
        return treeNodes;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftFind = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFind = lowestCommonAncestor(root.right, p, q);
        if (leftFind != null && rightFind != null) {
            return root;
        } else if (leftFind != null) {
            return leftFind;
        } else if (rightFind != null) {
            return rightFind;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> parentAndSelfNode = new LinkedList<>();
        travevalToBottom(root, p, parentAndSelfNode);
        List<TreeNode> anotherParent = new LinkedList<>();
        travevalToBottom(root, q, anotherParent);
        TreeNode i = getCommonTreeNode(parentAndSelfNode, anotherParent);
        return i;
    }

    private TreeNode getCommonTreeNode(List<TreeNode> parentAndSelfNode, List<TreeNode> anotherParent) {
        for (int i = anotherParent.size() - 1; i >= 0; i--) {
            for (int j = parentAndSelfNode.size() - 1; j >= 0; j--) {
                if (anotherParent.get(i).val == parentAndSelfNode.get(j).val) {
                    return anotherParent.get(i);
                }
            }
        }
        return null;
    }

    private boolean travevalToBottom(TreeNode root, TreeNode targetNode, List<TreeNode> parentAndSelfNode) {
        if (root == null) {
            return false;
        }
        parentAndSelfNode.add(root);
        if (root.val == targetNode.val) {
            return true;
        } else if (root.left == null && root.right == null) {
            return false;
        }
        boolean isFind = travevalToBottom(root.left, targetNode, parentAndSelfNode);
        if (!isFind) {
            removeFromEndExcept(parentAndSelfNode, root);
            isFind = travevalToBottom(root.right, targetNode, parentAndSelfNode);
            if (!isFind) {
                removeFromEndExcept(parentAndSelfNode, root);
            }
        }
        return isFind;
    }

    private void removeFromEndExcept(List<TreeNode> parentAndSelfNode, TreeNode root) {
        Iterator<TreeNode> treeNodeIterator = parentAndSelfNode.iterator();
        boolean isFindTar = false;
        List<TreeNode> remove = new LinkedList<>();
        while (treeNodeIterator.hasNext()) {
            TreeNode nexVal = treeNodeIterator.next();
            if (nexVal.val == root.val) {
                isFindTar = true;
            } else if (isFindTar) {
                remove.add(nexVal);
            }
        }
        parentAndSelfNode.removeAll(remove);
    }


    /**
     * add by liudeyu 2020, 定义好子问题，找到一个就算
     */
    public TreeNode findDeepCommonParent(TreeNode root, TreeNode first, TreeNode second) {
        if (root == null) {
            return null;
        }

        if (root.equals(first) || root.equals(second)) {
            return root;
        }

        TreeNode tmp = findDeepCommonParent(root.left, first, second);
        TreeNode tmp2 = findDeepCommonParent(root.right, first, second);
        if (tmp != null && tmp2 != null) {
            return root;
        } else if (tmp == null) {
            return tmp2;
        } else {
            return tmp;
        }
    }

    public static void main(String[] argv) {

        FindDeepCommonParent findDeepCommonParent = new FindDeepCommonParent();
        TreeNode root = new TreeNode(3).setLeft(new TreeNode(5).setLeft(new TreeNode(6)).setRight(new TreeNode(2).setLeft(new TreeNode(7)).setRight(new TreeNode(4))))
                .setRight(new TreeNode(1).setLeft(new TreeNode(0)).setRight(new TreeNode(8)));
        TreeUtils.printTree(root);
//        System.out.println(findDeepCommonParent.lowestCommonAncestor3(root, new TreeNode(7), new TreeNode(4)));
        System.out.println("result is ");
        System.out.println(findDeepCommonParent.findDeepCommonParent(root, new TreeNode(6), new TreeNode(4)));


    }
}
