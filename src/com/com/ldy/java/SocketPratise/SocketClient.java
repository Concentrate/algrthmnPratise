package com.ldy.java.SocketPratise;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/5/21.
 */
public class SocketClient {


    private String HOST = "127.0.0.1";
    private int PORT = 1098;

    public void connect() {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        try {
            socket = new Socket(HOST, PORT);
            String line;
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            line = scanner.nextLine();
            byte[] bytesData = line.getBytes("utf8");
            bufferedOutputStream.write(bytesData);
            bufferedOutputStream.flush();
            while (true) {
                byte[] res = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(res);
                if (res.length != 0) {
                    String response = new String(res, "utf8");
                    System.out.println(response);
                    line=scanner.nextLine();
                    bytesData = line.getBytes("utf8");
                    bufferedOutputStream.write(bytesData);
                    bufferedOutputStream.flush();
                }
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

    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.connect();

    }
}
