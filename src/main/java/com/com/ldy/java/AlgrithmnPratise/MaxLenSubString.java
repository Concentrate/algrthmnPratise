package com.com.ldy.java.AlgrithmnPratise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/3/11.
 */
public class MaxLenSubString {
    public static void main(String[]argv){
        MaxLenSubString maxLenSubString=new MaxLenSubString();
        while(true){
            Scanner scanner=new Scanner(System.in);
            String m=scanner.next();
            System.out.println(maxLenSubString.lengthOfLongestSubstring(m));
        }
    }
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        HashSet<Character>hashSet=new HashSet<>();
        HashMap<Character,Integer>hashMap=new HashMap<>();
        int maxNum= Integer.MIN_VALUE;
        int tmpNum=0;
        for(int i=0;i<s.length();i++){
            if(!hashSet.contains(s.charAt(i))){
                tmpNum++;
                hashSet.add(s.charAt(i));
                hashMap.put(s.charAt(i),i);
            }else{

                int beforIndex=hashMap.get(s.charAt(i));
                tmpNum=(i-1)-beforIndex+1;
                hashMap.put(s.charAt(i),i);
                hashSet.clear();
                for(int a1=beforIndex+1;a1<=i;a1++) {
                    hashSet.add(s.charAt(a1));
                }

            }
            if(maxNum<tmpNum){
                maxNum=tmpNum;
            }

        }
        return maxNum;
    }
}
