package com.com.ldy.java.Util;

import com.ldy.java.AlgrithmnPratise.ConstantsVariable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/8/31.
 */
public class InputUtil {
    public static int TYPE_STDIN=1;
    public static int TYPE_FILE=2;
    public static Scanner getFileScanner() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }

}
