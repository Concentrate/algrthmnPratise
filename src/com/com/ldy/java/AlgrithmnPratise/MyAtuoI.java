package com.ldy.java.AlgrithmnPratise;

/**
 * Created by liudeyu on 2017/3/12.
 */
public class MyAtuoI {
    public int myAtoi(String str) {
        int t = 0;
        try {
            str=str.trim();
            String[]tmpArray = new String[0];
            boolean isContailSpace=false;
            if(str.contains(" ")){
               tmpArray=str.split(" ");
               isContailSpace=true;
            }
            StringBuilder realInput=new StringBuilder();
            for(String a1: tmpArray){
                if(!a1.contains(" ")){
                    realInput.append(realInput);
                }
            }
            if(isContailSpace) {
                str = realInput.toString();
            }
            boolean isNeg = str.startsWith("-");
            StringBuilder builder = new StringBuilder();
            String tmp = isNeg ? str.substring(1) : str;
            int i = 0;
            while (i < tmp.length()) {
                if (tmp.charAt(i) != '0') {
                    break;
                }
            }
            if (i == tmp.length()) {
                return 0;
            } else {
                while (i < tmp.length()) {
                    builder.append(tmp.charAt(i++));
                }
            }
            t = Integer.valueOf(builder.toString());
            if (isNeg) {
                t = -t;
            }
        } catch (NumberFormatException g) {
            return 0;
        }
        return t;
    }

    public static void main(String[] argv) {

        String m="-+1";
        System.out.println(Integer.valueOf(m));
    }
}
