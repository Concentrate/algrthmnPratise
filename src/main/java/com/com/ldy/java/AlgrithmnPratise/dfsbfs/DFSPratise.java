package com.com.ldy.java.AlgrithmnPratise.dfsbfs;

/**
 * Created by liudeyu on 2017/3/10.
 */

/**求n位数的全排列*/
public class DFSPratise {
    private  int []book;
    private int []result;
    private int allNum;

    public int getAllNum() {
        return allNum;
    }

    public DFSPratise(){
        book=new int[10];
        result=new int[10];
        initData();
    }
    void initData(){
        for(int i=0;i<10;i++){
            book[i]=result[i]=0;
        }
        allNum=0;
    }
    /**求n位数的全排列*/
    void fullPremution(int n){
        toImplementFullPremution(0,n);
    }

    private void toImplementFullPremution(int i, int n) {
        if(i>=n){
            for(int a1=0;a1<i;a1++){
                System.out.print(result[a1]);
            }
            System.out.println("");
            allNum++;
            return;
        }
        for(int a1=0;a1<10;a1++){
            if(book[a1]==0){
               if(i==0&&a1==0){
                   continue;
               }
               book[a1]=1;
               result[i]=a1;
               toImplementFullPremution(i+1,n);
               book[a1]=0;
            }
        }
    }

    public static void main(String[]argvs){
            DFSPratise dfsPratise=new DFSPratise();
            dfsPratise.initData();
            dfsPratise.fullPremution(3);
            System.out.println("all num result is "+dfsPratise.getAllNum());
    }
}
