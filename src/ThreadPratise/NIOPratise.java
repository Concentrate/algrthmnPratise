package ThreadPratise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by liudeyu on 2017/7/17.
 */
public class NIOPratise {
   public static  String filePath="/Users/liudeyu/project/javaPratiseProject/src/ThreadPratise/NIOPratise.java";
    public static void main(String[]argv){
            readFileUsedBuffer();
    }

    private static void readFileUsedBuffer() {
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(filePath,"rw");
            FileChannel inChanel=randomAccessFile.getChannel();
            ByteBuffer byteBuffer=ByteBuffer.allocate(24);
            int readCount=0;
            while((readCount=inChanel.read(byteBuffer))!=-1){
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    System.out.print((char)byteBuffer.get());
                }
                byteBuffer.clear();
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
