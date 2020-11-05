package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.Tree;

/**
 * @author: liudeyu
 * @date: 2020/11/5
 */

/**
 * 判断是否是子树
 */
public class IsSubTreePro {


    boolean isEqualTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        }

        if (left.val == null) {
            if (right.val == null) {
                return true;
            } else {
                return false;
            }
        }
        return left.val.equals(right.val) && isEqualTree(left.left, right.left) && isEqualTree(left.right, right.right);
    }


    boolean isSubTree(TreeNode parent, TreeNode ifSon) {
        if (ifSon == null) {
            return true;
        }

        if (parent == null && ifSon != null) {
            return false;
        }

        boolean isEqual = isEqualTree(parent, ifSon);
        if (isEqual) {
            return isEqual;
        }
        return isSubTree(parent.left, ifSon) || isSubTree(parent.right, ifSon);

    }

    public static void main(String[] args) {
        IsSubTreePro treePro = new IsSubTreePro();
        Integer[] tmpArr = new Integer[]{3, 4, 5, 1, 2, null, null, null, 0};
        Integer[] subArr = new Integer[]{4, 1, 2};
        TreeNode parent = TreeUtils.createLevelTravelTree(tmpArr);
        TreeNode son = TreeUtils.createLevelTravelTree(subArr);
        TreeUtils.printTree(parent);
        TreeUtils.printTree(son);

        System.out.println("is sub Tree " + treePro.isSubTree(parent, son));

    }
}
