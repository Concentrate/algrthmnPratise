package com.com.ldy.java.concurrentPratise;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.tools.json.JSONUtil;

import java.util.Map;

public class JudgeIfJson {

    public static boolean isJsonString(String rawString){
        Object object=null;
        try {

         object=JSONObject.parse(rawString);
        }catch (Exception e){

        }
        return object!=null;

    }




    public static void main(String[] args) {


    }
}
