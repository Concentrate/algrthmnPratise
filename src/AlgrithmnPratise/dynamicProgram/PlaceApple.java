package AlgrithmnPratise.dynamicProgram;


import java.util.Scanner;

/**
 * Created by liudeyu on 2017/6/10.
 */
public class PlaceApple {
    /*n个苹果放在m个盘子里，有几种放法，这里唯一区别不同放法的就是盘子放苹果个数*/
    public static void main(String[] args) {
        int appleNum, plateNum;
        Scanner scanner = new Scanner(System.in);
        System.out.println("苹果个数:");
        appleNum = scanner.nextInt();
        System.out.println("盘子个数: ");
        plateNum = scanner.nextInt();
        System.out.println("different ditribute method are " + putInThePlate(appleNum, plateNum));


    }

    private static int putInThePlate(int appleNum, int plateNum) {
        if (appleNum <= 1) {
            return 1;
        }
        if (plateNum <= 1) {
            return 1;
        }
        if(appleNum<plateNum){
            return putInThePlate(appleNum,appleNum);
        }else{
            return putInThePlate(appleNum,plateNum-1)+putInThePlate(appleNum-plateNum,plateNum);
        }

    }
}
