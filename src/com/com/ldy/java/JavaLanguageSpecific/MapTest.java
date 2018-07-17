package com.ldy.java.JavaLanguageSpecific;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by liudeyu on 2017/8/24.
 */
public class MapTest {
    public static void main(String[]argv){
        HashMap<String,String>map=new HashMap<>();
        HashSet<String>set=new HashSet<>();
        Hashtable<String,String>hashtable=new Hashtable<>();
        for(int i=0;i<10;i++){
            map.put(null,i+"");
            set.add(null);
            // wrong,hashtable can't add null
//            hashtable.put(null,null);
            map.put(i+"",null);
        }

        System.out.println(map.get(null));
        System.out.println(set.contains(null));
        System.out.println(map.get(9));


    }
}
