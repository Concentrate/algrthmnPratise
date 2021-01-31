package com.com.ldy.java.AlgrithmnPratise;

public class NewOne {

    ///

   String reverString(String tmp){
       if(tmp==null||tmp.length()==0){
           return tmp;
       }
       StringBuilder result=new StringBuilder();

       for(int i=tmp.length()-1;i>=0;i--){
           result.append(tmp.substring(i,i+1));
       }
       return result.toString();
   }


    String add(String a, String b) {

        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        //  judge vaild

        int aLength = a.length();
        int bLength = b.length();

        int[] tmpResult = new int[Math.max(aLength, bLength) + 1];
        for (int a1 = 0; a1 < tmpResult.length; a1++) {
            tmpResult[a1] = -1;
        }

        int addDelta = 0;
        int curIndex = 0;
        a=reverString(a);
        b=reverString(b);

        while (curIndex < Math.max(aLength, bLength)) {

            int tmpIndexSum = addDelta;
            if (curIndex < aLength) {
                tmpIndexSum += Integer.valueOf(a.substring(curIndex,curIndex+1));
            }

            if (curIndex < bLength) {
                tmpIndexSum += +Integer.valueOf(b.substring(curIndex,curIndex+1));
            }
            tmpResult[curIndex++] = tmpIndexSum % 10;
            addDelta = tmpIndexSum / 10;
        }

        if(addDelta>0){
            tmpResult[curIndex]=addDelta;
        }

        StringBuilder finRes=new StringBuilder();
        for(int b1=tmpResult.length-1;b1>=0;b1--){
            if(tmpResult[b1]==-1){
                continue;
            }
            finRes.append(tmpResult[b1]);
        }
        return finRes.toString();

    }


    public static void main(String[] args) {

        String row1="9";
        String row2="99";

        NewOne newOne=new NewOne();
        System.out.println(String.format("%s + %s = %s", row1,row2,newOne.add(row1,row2)));
    }

}
