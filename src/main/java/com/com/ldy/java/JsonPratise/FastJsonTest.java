package com.com.ldy.java.JsonPratise;

import com.alibaba.fastjson.JSON;

/**
 * Created by liudeyu on 2017/9/12.
 */
public class FastJsonTest {
    private final String TestJson="{\"url\": \"https://api.huoshan.com/hotsoon/feed/?type=video&min_time=0&count=20\", \"header\": {\"Cookie\": \"qh[360]=1; install_id=14672554921; ttreq=1$9a768a6c8356caff1d93f64d7947cee01b299941; login_flag=81646bcf8ff80fe7ba2995ca9759a74d; sessionid=d4b41c44217e913d2a66319cecf58f30; uid_tt=77387e22f5c3b71ce2619121a70267da; sid_tt=d4b41c44217e913d2a66319cecf58f30; sid_guard=\\\"d4b41c44217e913d2a66319cecf58f30|1505187745|15552000|Sun\\\\054 11-Mar-2018 03:42:25 GMT\\\"\", \"User-Agent\": \"okhttp/3.8.1\"}, \"append_param\": false, \"method\": \"GET\"}";
    private final String TESTPOST="{\"url\": \"https://api.huoshan.com/hotsoon/item/6455251437810093325/_action/\", \"header\": {\"Cookie\": \"qh[360]=1; install_id=14672554921; ttreq=1$9a768a6c8356caff1d93f64d7947cee01b299941; login_flag=81646bcf8ff80fe7ba2995ca9759a74d; sessionid=d4b41c44217e913d2a66319cecf58f30; uid_tt=77387e22f5c3b71ce2619121a70267da; sid_tt=d4b41c44217e913d2a66319cecf58f30; sid_guard=\\\"d4b41c44217e913d2a66319cecf58f30|1505187745|15552000|Sun\\\\054 11-Mar-2018 03:42:25 GMT\\\"\", \"Content-Type\": \"application/x-www-form-urlencoded\", \"User-Agent\": \"okhttp/3.8.1\"}, \"append_param\": false, \"body\": \"type=6&iid=14672554921&device_id=38771165116&ac=wifi&channel=local_test&aid=1112&app_name=live_stream&version_code=270&version_name=2.7.0&device_platform=android&ssmix=a&device_type=KNT-UL10&device_brand=HONOR&os_api=24&os_version=7.0&uuid=869394023518357&openudid=e824fc9a28675385&manifest_version_code=270&resolution=1080*1815&dpi=440&update_version_code=2700\", \"method\": \"POST\"}";
    TestModel getJsonObjectTest(){
        TestModel testModel= JSON.parseObject(TESTPOST,TestModel.class);
        return testModel;
    }
    
    public static void main(String[]argv){
//            FastJsonTest test1.file=new FastJsonTest();
//            TestModel model=test1.file.getJsonObjectTest();
//            System.out.println(model);
//            if(model!=null){
//                if(model.header!=null){
//                    for(String t:model.header.keySet()){
//                        System.out.println(t+":   "+model.header.get(t));
//                    }
//                }
//            }
//            if(model.notExist==null){
//                System.out.println("notExist field no exist ");
//            }
        System.out.println(JSON.toJSONString(""));

        if(JSON.parseObject(JSON.toJSONString(null))==null){
            System.out.println("is null");
        }
    }
}
