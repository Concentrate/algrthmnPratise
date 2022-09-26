package com.com.ldy.java.common;

import java.util.LinkedList;
import java.util.List;

public class MrSecond {


    private boolean isVailedNum(String tmp) {
        Integer va;
        try {
            va = Integer.parseInt(tmp);
        } catch (Exception e) {
            return false;
        }
        return va >= 0 && va <= 255;
    }

    // 123ab456abc789ab,  ab,
    String[] split(String rawString, String splitor) {

        if(rawString==null||rawString.length()==0){
            return new String[]{};
        }


        List<String> result = new LinkedList<>();

        int fromIndex = 0;
        int lastIndex = 0;
        while (lastIndex < rawString.length()) {
            fromIndex = rawString.indexOf(splitor, lastIndex);
            if (fromIndex == -1) {

                result.add(rawString.substring(lastIndex));

                break;
            }


            String element = rawString.substring(lastIndex, fromIndex);
            result.add(element);
            lastIndex = fromIndex + splitor.length();
        }

        if(result.isEmpty()){
            result.add(rawString);
        }
        String[] tmp2=new String[result.size()];
        return  result.toArray(tmp2);

    }

    public boolean isVailedIP(String tmp) {
        if (tmp == null || tmp.length() < 8) {
            return false;
        }

        if (tmp.endsWith(".") || tmp.startsWith(".")) {
            return false;
        }

        String[] spliteArray = tmp.split(".");
        if (spliteArray == null || spliteArray.length != 4) {
            return false;
        }
        boolean result = true;
        for (int i = 0; i < spliteArray.length; i++) {

            result = result & isVailedNum(spliteArray[i]);
        }
        return result;

    }

    public static void main(String[] args) {
        MrSecond mrSecond = new MrSecond();

        System.out.println(mrSecond.split("123.23.22.233","."));

        // 123..2.33..2

//            System.out.println(mrSecond.isVailedIP("1.2..3..4"));
    }
}
