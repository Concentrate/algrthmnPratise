package AlgrithmnPratise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/4/5.
 */
public class MaxContinusArraySum {
    public static String DATA_PATH="/Users/liudeyu/data.txt";
    public static void main(String[]args){
        try {
            Scanner scanner=new Scanner(new FileInputStream(DATA_PATH));
            int n;
            n=scanner.nextInt();
            int []array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=scanner.nextInt();
            }
            int []maxSubSum=new int[n+1];
            maxSubSum[0]=0;
            int startIndex=0,endIndex = 0;
            int aMaxSum=array[0];
            for(int i=1;i<=n;i++){
                if(maxSubSum[i-1]+array[i-1]>array[i-1]){
                  maxSubSum[i]=maxSubSum[i-1]+array[i-1];
                }else{
                    maxSubSum[i]=array[i-1];
                }
                if(maxSubSum[i]>aMaxSum){
                    aMaxSum=maxSubSum[i];
                }

            }
            System.out.println("the left index is "+startIndex+" and the right index is "+endIndex
            +"\n"+"the max sub sum is "+aMaxSum);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
