package AlgrithmnPratise.dynamicProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/6/10.
 */
public class StringEditDistance {

    static int threeMin(int a,int b,int c){
        int theMin=Math.min(a,b);
        return Math.min(theMin,c);
    }

    static int miniDistance(String raw,String after){
        if((raw==null&&after==null)||raw.equals(after)) {
            return 0;
        }
        if(raw==null&&after!=null){
            return after.length();
        }
        if(raw!=null&&after==null){
            return raw.length();
        }

        int [][]recordArray=new int[raw.length()+1][];
        for(int i=0;i<=raw.length();i++){
            recordArray[i]=new int[after.length()+1];
        }
        for(int a1=0;a1<=raw.length();a1++){
            recordArray[a1][0]=a1;
        }
        for(int a2=0;a2<=after.length();a2++){
            recordArray[0][a2]=a2;
        }
        recordArray[0][0]=0;
        for(int a1=1;a1<=raw.length();a1++){
            for(int a2=1;a2<=after.length();a2++){
                if(raw.charAt(a1-1)==after.charAt(a2-1)){
                    recordArray[a1][a2]=recordArray[a1-1][a2-1];
                }else{
                    recordArray[a1][a2]=threeMin(recordArray[a1][a2-1]+1,
                            recordArray[a1-1][a2-1]+1,recordArray[a1-1][a2]+1);
                }
            }
        }

        return recordArray[raw.length()][after.length()];
    }
    public static void main(String[]args){
        Scanner scanner= null;
        try {
            scanner = new Scanner(new FileInputStream("/Users/liudeyu/data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String raw,toMatch;
//        Scanner scanner=new Scanner(System.in);
        raw=scanner.nextLine();
        toMatch=scanner.nextLine();
        System.out.println(miniDistance(raw,toMatch));



    }
}
