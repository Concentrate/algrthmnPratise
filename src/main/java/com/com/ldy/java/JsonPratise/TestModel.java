package com.com.ldy.java.JsonPratise;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;

import java.util.Map;

/**
 * Created by liudeyu on 2017/9/12.
 */
public class TestModel {
    @JSONField(name = "header")
    public Map<String, String> header;
    @JSONField(name = "url")
    public String url;
    @JSONField(name = "notExist")
    public String notExist;
    @JSONField(name="body")
    public String body;

    @Override
    public String toString() {
        return "TestModel{" +
                "header=" + header +
                ", url='" + url + '\'' +
                ", notExist='" + notExist + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
