package AlgrithmnPratise;

import java.util.Scanner;

/**
 * Created by liudeyu on 2017/4/7.
 */
public class Main {
    int []spendMoney;
    float []possibity;
    float maxProssibity;
    int totalMoney;


    float solve(){
        int num=spendMoney.length-1;
        float []proArray=new float[totalMoney+1];
        for(int i=1;i<=num;i++){
            for(int j=totalMoney;j>=spendMoney[i];j--){
                proArray[j]=Math.max(cacluUnionOfPro(proArray[j-spendMoney[i]],possibity[i]),proArray[j]);
            }
        }
        return proArray[totalMoney];
    }

    private float cacluUnionOfPro(float v, float v1) {
        return (v+v1)-v*v1;
    }

    public static void main(String[]args){
        int totalMoney,n;
        Scanner scanner=new Scanner(System.in);
        totalMoney=scanner.nextInt();
        n=scanner.nextInt();
        int []ocupyMoney=new int[n+1];
        float []pro=new float[n+1];
        for(int i=1;i<=n;i++){
            ocupyMoney[i]=scanner.nextInt();
            pro[i]=scanner.nextFloat();
        }
        Main one=new Main();
        one.totalMoney=totalMoney;
        one.possibity=pro;
        one.spendMoney=ocupyMoney;
        float result=one.solve();
        System.out.println(result*100+"%");

    }
}
