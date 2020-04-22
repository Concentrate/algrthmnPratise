package com.com.ldy.java.singleton;

/**
 * Created by liudeyu on 2020/3/13.
 */
public class SingleTon2 {

    private volatile static SingleTon2 instance;

    private SingleTon2() {
    }

    public static SingleTon2 getInstance() {
        if (instance == null) {
            synchronized (SingleTon2.class) {
                if (instance == null) {
                    instance = new SingleTon2();
                }
            }
        }
        return instance;
    }
}
