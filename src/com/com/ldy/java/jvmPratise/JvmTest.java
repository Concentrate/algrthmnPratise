package com.ldy.java.jvmPratise;

import sun.misc.Launcher;

/**
 * Created by liudeyu on 2017/8/10.
 */
public class JvmTest {
    public static void main(String[]argv){
        Launcher launcher=Launcher.getLauncher();
        System.out.println(launcher.getClassLoader());
        System.out.println(Launcher.getLauncher());
    }
}
