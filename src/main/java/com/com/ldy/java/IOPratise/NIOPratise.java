package com.com.ldy.java.IOPratise;


import com.ldy.java.AlgrithmnPratise.ConstantsVariable;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by liudeyu on 2017/9/19.
 */
public class NIOPratise {

    static String PATH = "/Users/liudeyu/project/javaPratiseProject/java/IOPratise";

    public static void main(String[] argv) {
        try {
            FileChannel fileChanel = new FileInputStream(ConstantsVariable.DATA_PATH).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int readNum = fileChanel.read(byteBuffer);
            FileChannel writeOutChanle = new FileOutputStream(PATH + File.separator + "text.txt").getChannel();
            byte[]tmp=new byte[100];
            while (readNum != -1) {
                System.out.println("read count is " + readNum);
                System.out.println(new String(byteBuffer.array(),"utf8"));
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    writeOutChanle.write(byteBuffer);
                }
                byteBuffer.clear();
                readNum = fileChanel.read(byteBuffer);

            }
            fileChanel.close();
            writeOutChanle.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
