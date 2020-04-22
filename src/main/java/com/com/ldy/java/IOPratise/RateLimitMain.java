package com.com.ldy.java.IOPratise;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by liudeyu on 2020/2/11.
 */
public class RateLimitMain {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rateLimiter.acquire();
                    System.out.println("pass");
                }
            }).start();
        }
    }
}