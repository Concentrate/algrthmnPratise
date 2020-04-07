package com.com.ldy.java.common;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liudeyu on 2020/2/20.
 */
public class CmdLimitRequest {

    volatile AtomicInteger cmdNum = new AtomicInteger(5);


    public CmdLimitRequest() {

        initCmdInput();
    }

    public boolean executeGet() {
        return cmdNum.decrementAndGet() > 0;
    }


    private void initCmdInput() {
        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.schedule(() -> {
            cmdNum.set(5);

        }, 10, TimeUnit.SECONDS);

    }

    public static void main(String[] argv) {

        CmdLimitRequest request = new CmdLimitRequest();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                if (request.executeGet()) {

                    //todo 拿到令牌后续操作

                } else {
                    System.out.println("block");
                }
            });
        }

        Integer g1 = 13;
        setIntegerNum(g1);
        System.out.println(g1);
        Character character='a';
        Set<Character> tmpChars=new HashSet<>();
        String tmpInput="hello,my world";
        Character one=tmpInput.charAt(0);
    }

    public static void setIntegerNum(Integer a) {
        a = 3;
    }
}
