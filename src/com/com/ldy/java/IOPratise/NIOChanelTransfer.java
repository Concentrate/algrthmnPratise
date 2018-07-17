package com.ldy.java.IOPratise;

import jdk.management.resource.internal.inst.FileChannelImplRMHooks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * Created by liudeyu on 2017/7/18.
 */
public class NIOChanelTransfer {
    public static String fromPath="/Users/liudeyu/project/javaPratiseProject/java/IOPratise/NIOChanelTransfer.java";
    public static String toPath="/Users/liudeyu/project/javaPratiseProject/java/IOPratise/copy.txt";
    public static String toPath1="/Users/liudeyu/project/javaPratiseProject/java/IOPratise/date.txt";
    public static void main(String[]argv){
//        copyText();
        writeToTextFile();

    }

    private static void writeToTextFile() {
        try {
            RandomAccessFile accessFile=new RandomAccessFile(toPath,"rw");
            FileChannel channel=accessFile.getChannel();
            ByteBuffer byteBuffer=ByteBuffer.allocate(48);
            byteBuffer.clear();
            Date date=new Date();
            String result="hello ,world  "+date.toString();
            byteBuffer.put(result.getBytes());
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                channel.write(byteBuffer);
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyText() {
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(fromPath,"rw");
            FileChannel channel=randomAccessFile.getChannel();
            RandomAccessFile writeTo=new RandomAccessFile(toPath,"rw");
            FileChannel copyChanel=writeTo.getChannel();
            channel.transferTo(0,channel.size(),copyChanel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
