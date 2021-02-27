package com.arrayabout;


import com.com.ldy.java.concurrentPratise.JudgeIfJson;
import org.junit.Test;

public class TestIfJson {

    @Test
    public void test() {
        System.out.println("hello");
    }


    @Test
    public void testIfJson() {
        String testContent = "{}";
        String test1 = "{ 'one':'abcd'   }";
        String test2 = "{ 'one':['abcd']   }";
        String test3 = "{ 'one':'abcd',,,  ";
        String test4 = "{ 'one':'abcd'," +
                "'two':['ok']   }";
        String test5="[ {'ok':'ok'},{'ok1':'ok1'}   ]";

        assert JudgeIfJson.isJsonString(testContent) == true;
        assert JudgeIfJson.isJsonString(test1) == true;
        assert JudgeIfJson.isJsonString(test2) == true;
        assert JudgeIfJson.isJsonString(test3) == false;
        assert JudgeIfJson.isJsonString(test4) == true;
        assert JudgeIfJson.isJsonString(test5) == true;


    }


}
