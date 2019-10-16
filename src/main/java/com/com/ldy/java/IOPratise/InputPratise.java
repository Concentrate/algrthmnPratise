package com.com.ldy.java.IOPratise;


import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by liudeyu on 2017/8/30.
 */
public class InputPratise {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        String delimiter = scanner.delimiter().toString();
//        scanner.skip(",");
        System.out.println(String.format("%.2f,%.3f", 0.2, 99.33));
        String str = "ok";
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println(integer);
            }
        });
        List<TestNode> list = new ArrayList<>();

        list.add(new TestNode(1));
        list.add(new TestNode(2));
        TestNode[] testNodes = new TestNode[list.size()];
        list.toArray(testNodes);
        testNodes[0].i = 10;
        System.out.println(list.get(0).i);
        LinkedList<TestNode> linkedList = new LinkedList<>();
        TreeMap<Integer,Integer>treeMap=new TreeMap<>();
        PriorityQueue<Integer>priorityQueue=new PriorityQueue<>();
        List<Integer>integers=Arrays.asList(1,2,3);
        System.out.println(Integer.bitCount(4));
        List<String> langs = new ArrayList<String>();
        langs.add("a");
        langs.add("b");
        langs.add("c");
        langs.add("d");
        Collections.rotate(langs, -1);
        for (String lang : langs)
            System.out.println("lang : " + lang);

    }
}

class TestNode {
    int i;

    public TestNode(int i) {
        this.i = i;
    }

    public TestNode() {
    }
}