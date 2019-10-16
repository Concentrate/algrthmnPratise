package com.com.ldy.java.JavaLanguageSpecific;


import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liudeyu on 2017/4/28.
 */
public class WeakRefrencePratise {
    public static void main(String[]args){
        Node one=new Node();
        WeakReference<Node>r1=new WeakReference<Node>(one);
        WeakReference<Node>r2=new WeakReference<Node>(one);
        if(r1.get().equals(r2.get())){
            System.out.println("yes");
        }
        Set<WeakReference<Node>>sets=new HashSet<>();
        sets.add(r1);
        sets.add(r2);
        System.out.println("size is "+sets.size());
    }
}
class Node{
    int value;
    String name;
}
