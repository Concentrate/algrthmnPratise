package com.com.ldy.java.DataStuctPratise;

import java.util.*;

/**
 * Created by liudeyu on 2017/4/26.
 */
public class Main {
    public static void main(String[] args) {
        String raw;
        Scanner scanner=new Scanner(System.in);
        raw=scanner.nextLine();
        int t=0;
        int start=1;
        while(start<raw.length()-1){
            if(raw.charAt(start)==raw.charAt(start-1)||raw.charAt(start)==raw.charAt(start+1)){
                t++;
            }
            start+=2;
        }
        System.out.println(t);
    }


}
