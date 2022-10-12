package com.com.ldy.java.AlgrithmnPratise;

public class second {


    public static void main(String[] args) {
        System.out.println("this is the start");
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                    System.out.println("this is runnable");
            }
        };
        Thread t1=new Thread(r1);
        t1.start();

    }
}
