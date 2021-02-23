package com.com.ldy.java.AlgrithmnPratise.unionandfind;

import org.springframework.util.Assert;

/**
 * @author: liudeyu
 * @date: 2021/2/23
 */
public class UnionAndFind {

    private int[] unionArray;
    private static int CAPACITY = 100;

    public UnionAndFind() {
        unionArray = new int[CAPACITY];
        for (int i = 0; i < unionArray.length; i++) {
            unionArray[i] = i;
        }
    }

    void union(int a, int b) {
        Assert.isTrue(a < CAPACITY, "should smaller");
        Assert.isTrue(b < CAPACITY, "should smaller");
        int tmp = a;
        while (unionArray[tmp] != tmp) {
            tmp = unionArray[tmp];
        }
        int tmp2 = b;
        while (unionArray[tmp2] != tmp2) {
            int c1 = unionArray[tmp2];
            unionArray[tmp2] = tmp;
            tmp2 = c1;
        }
        unionArray[tmp2] = tmp;
        unionArray[tmp] = tmp;
    }


    boolean isUnion(int a, int b) {
        int tmp1 = a;
        while (tmp1 != unionArray[tmp1]) {
            tmp1 = unionArray[tmp1];
        }
        int tmp2 = b;
        while (tmp2 != unionArray[tmp2]) {
            tmp2 = unionArray[tmp2];
        }

        return unionArray[tmp1] == unionArray[tmp2];
    }


    public static void main(String[] args) {
        UnionAndFind unionAndFind = new UnionAndFind();
        unionAndFind.union(1, 3);
        unionAndFind.union(2, 4);
        unionAndFind.union(6, 7);
        System.out.println(unionAndFind.isUnion(1, 2));
        unionAndFind.union(3, 4);
//        unionAndFind.union(6, 4);
        System.out.println(unionAndFind.isUnion(1, 2));
        System.out.println(unionAndFind.isUnion(2, 6));


    }
}
