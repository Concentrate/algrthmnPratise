package com.com.ldy.java.AlgrithmnPratise.soul;

public class SingleInstance {


    public static SingleInstance getInstance() {
        return InnerClass.singleInstance;
    }

    private static class InnerClass {
        static SingleInstance singleInstance = new SingleInstance();
    }

    private static volatile SingleInstance singleInstance;


    public static SingleInstance getInstance2() {

        if (singleInstance != null) {
            return singleInstance;
        }
        synchronized (singleInstance) {

            if (singleInstance == null) {
                singleInstance = new SingleInstance();
            }


        }
        return singleInstance;

    }

}
