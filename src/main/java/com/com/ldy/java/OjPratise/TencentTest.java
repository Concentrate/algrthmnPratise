package com.com.ldy.java.OjPratise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/8/29.
 */
public class TencentTest {
    public static void main(String[]argv){
        Scanner scanner=new Scanner(System.in);
        Map<Integer,Integer> map=new HashMap<>();
        while (scanner.hasNext()){
            String tmp=scanner.next();
            tmp=tmp.substring(0,tmp.length());
            int number=0;
            if(isNumberString(tmp)){
                number=Integer.parseInt(tmp);
            }else{
                continue;
            }
            if(map.containsKey(number)){
                map.put(number,map.get(number)+1);
            }else{
                map.put(number,1);
            }

        }
        for(Integer a1:map.keySet()) {
            System.out.println(a1+":"+"("+map.get(a1)+")");
        }
    }

    private static boolean isNumberString(String tmp) {
        for(int i=0;i<tmp.length();i++){
            if(!Character.isDigit(tmp.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
