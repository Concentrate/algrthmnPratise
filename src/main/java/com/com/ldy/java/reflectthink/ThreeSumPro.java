package com.com.ldy.java.reflectthink;

import java.util.Arrays;

public class ThreeSumPro {



    public  static void threeSum(int []rawArray){
        if(rawArray==null||rawArray.length<=2){
            return;
        }
        Arrays.sort(rawArray);


        int firstIndex=1;
        int curseCurrent=0;
        int lastIndex=rawArray.length-1;


        while (curseCurrent<=rawArray.length-3){

            firstIndex= curseCurrent+1;
            lastIndex=rawArray.length-1;
            int targetSum=-rawArray[curseCurrent];
            while (firstIndex<lastIndex){
                if(rawArray[firstIndex]+rawArray[lastIndex]<targetSum){
                    firstIndex++;

                }else if(rawArray[firstIndex]+rawArray[lastIndex]>targetSum){
                    lastIndex--;
                }else{
                    System.out.println(String.format("%s+%s+%s=0",rawArray[firstIndex],rawArray[lastIndex],-targetSum));
                    firstIndex++;
                    lastIndex--;
                }
            }
            curseCurrent++;
        }



    }


    public static void main(String[] args) {

        int []tmpArray={-3,-5,0,-1,-2,2,1,4,1};
        threeSum(tmpArray);
    }
}
