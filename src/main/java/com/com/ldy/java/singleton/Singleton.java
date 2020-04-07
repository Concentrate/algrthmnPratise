package com.com.ldy.java.singleton;

/**
 * Created by liudeyu on 2020/3/13.
 */
public class Singleton {
    private Singleton(){
    }
    public static Singleton getInstance(){
        return SingletonHolder.sInstance;
    }
    private static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }


}
