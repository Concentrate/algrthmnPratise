package com.com.ldy.java.lock;

import java.util.Timer;

public class JavaDeadLockDemo {


    static class R1 implements Runnable{
        Object a,b;
        public R1(Object a1,Object a2){
            this.a=a1;
            this.b=a2;
        }

        public void run(){
            synchronized (a){
                try {
                    System.out.println("before dead lock"+Thread.currentThread().getName());
                    Thread.sleep(1000);
                    synchronized (b){
                        System.out.println("get both");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
    public static void main(String[] args) {
        String a="a",b="b";
        new Thread(new R1(a,b),"t1").start();
        new Thread(new R1(b,a),"t2").start();
    }
}
