package com.com.ldy.java.IOPratise;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by liudeyu on 2017/7/18.
 */
public class NIoSocketPratise {
    static String url="http://jenkov.com";
    public static void main(String[]argv){
        getRequestFromNio();

    }

    public static void getRequestFromNio() {
        try {
            SocketChannel socketChannel=SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(url,80));
            ByteBuffer byteBuffer=ByteBuffer.allocate(48);
            int count=0;
            count=socketChannel.read(byteBuffer);
            while (count!=-1){
                byte[]array=new byte[count];
                byteBuffer.get(array,0,count);
                System.out.print(new String(array,"utf8"));
                byteBuffer.flip();
                count=socketChannel.read(byteBuffer);

            }
            socketChannel.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
