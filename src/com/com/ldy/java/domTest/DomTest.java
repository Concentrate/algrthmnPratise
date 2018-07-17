package com.ldy.java.domTest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liudeyu on 2018/2/2.
 */
public class DomTest {
    static String url = "https://m.weibo.cn/u/2855893887?uid=2855893887&luicode=20000061&lfid=4202958298714873";

    public static void main(String[] argv) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            String tmp = okHttpClient.newCall(request).execute().body().string();
            System.out.println(tmp);
            Document document = Jsoup.parse(tmp);
            System.out.println("*******&&&&&&&&&&&&");
            document.removeClass("aside");
            System.out.println(document.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getResponse(String url) throws IOException {
        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        int readCount = 0;
        byte[] res = new byte[inputStream.available()];
        inputStream.read(res);
        return new String(res, "UTF8");
    }
}


