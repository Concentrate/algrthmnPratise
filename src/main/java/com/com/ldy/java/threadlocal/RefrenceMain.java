package com.com.ldy.java.threadlocal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author: liudeyu
 * @date: 2021/3/17
 */
public class RefrenceMain {

    public static void  weakRefrenceTest(){
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        WeakReference<String> pr = new WeakReference<String>("wxj", queue);
        System.gc();
        System.out.println(queue.poll()); // 获取即将被回收的字符串　wxj

    }

    public static void main(String[] args) {
//        photmaRefrence();
        weakRefrenceTest();
    }

    private static void photmaRefrence() {
        String name = "csc";
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(name, queue);
        //PhantomRefrence的get方法总是返回null，因此无法访问对应的引用对象。
        System.out.println(queue.poll()); //获取被垃圾回收的"xb"的引用ReferenceQueue

        System.out.println(pr.get());  // null
        System.gc();
        System.out.println(queue.poll()); //获取被垃圾回收的"xb"的引用ReferenceQueue
    }


}
