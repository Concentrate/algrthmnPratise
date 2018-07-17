package com.ldy.java.JsonPratise;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.io.*;

/**
 * Created by liudeyu on 2017/9/13.
 */
public class TestJson {

    private static String OUTPUTJSONSTRING;

    public static void main(String[]argv){
        try {
            File currentPackageDir=new File("test");
            System.out.println(currentPackageDir.getAbsolutePath());
            InputStream inputStream=new FileInputStream(currentPackageDir.getAbsolutePath()+File.separator+"test.json");
            ByteArrayOutputStream byteOutputStream=new ByteArrayOutputStream();
            byte []tmp=new byte[1024];
            int read=0;
            while((read=inputStream.read(tmp))!=-1){
                    byteOutputStream.write(tmp,0,read);
            }
            byte[]totalData=byteOutputStream.toByteArray();
            JSONObject object= (JSONObject) JSON.parse(totalData, Feature.IgnoreNotMatch);
            OUTPUTJSONSTRING = currentPackageDir.getAbsolutePath() + File.separator + "jsonString";
            BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(OUTPUTJSONSTRING));
            outputStream.write(object.toJSONString().getBytes());
            outputStream.flush();
            outputStream.close();
            inputStream.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
