package com.com.ldy.java.reflectthink;

public class FindMiniParet {


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static TreeNode miniParent(TreeNode root,TreeNode first, TreeNode second) {
           if(first==null){
               return second;
           }

           if(second==null){
               return first;
           }
           if(root==null){
               return null;
           }

           if(root==first||root==second){
              return root;
           }


           TreeNode parent1=miniParent(root.left,first,second);

           TreeNode parent2=miniParent(root.right,first,second);

           if(parent1!=null&&parent2!=null){
               return root;
           }else if(parent1!=null){
               return parent1;
           }else{
               return parent2;
           }


    }


    public static void main(String[] args) {

    }
}
