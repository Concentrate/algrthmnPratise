package com.com.ldy.java.SocketPratise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liudeyu on 2017/5/22.
 */
public class MSocketServer {
    private static int PORT = 1098;
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public MSocketServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            executorService = Executors.newCachedThreadPool();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                executorService.execute(new DealWithSocketCommunication(socket));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MSocketServer socketServer = new MSocketServer();
        socketServer.connect();

    }

    public static class DealWithSocketCommunication implements Runnable {

        private Socket socket;

        public DealWithSocketCommunication(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                System.out.println(socket.getInetAddress().getHostAddress());
                String call;
                while (true) {
//                     有一个trick ,差点让我以为默认socket也能不阻塞就是,byte[]array=new byte[0]的时候，这个时候是能立即返回的，不管有没有数据，
//                    InputStream read api里面有解释，可以查看
                    byte[] array = new byte[1024]; // 数组容量足够大才能容纳每次输入的字符
                    ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                    int size = 0;
                    while ((size = inputStream.read(array)) != -1) {
                        String response = "Current thread " + Thread.currentThread().getName() + " echo: " + new String(array, 0, size, "utf8");
                        System.out.println("" + response);
                        outputStream.write(response.getBytes("utf8"));
                        outputStream.flush();
                    }
//                    这个证明socket read是阻塞的
                    System.out.println("nothing");
//                    if(array!=null&&array.length!=0) {
//                        String response = "Current thread " + Thread.currentThread().getName() + " echo: " + call;
//                        System.out.println(response);
//                        outputStream.write(response.getBytes("utf8"));
//                        outputStream.flush();
//                    }else{
//                        System.out.println("read nothing");
//                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
