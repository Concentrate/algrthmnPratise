package OjPratise;

import java.util.Scanner;

/**
 * Created by liudeyu on 2017/9/10.
 */
public class toutiao2 {
    int userNum;
    int[] recordLike;

    void inputArray(Scanner scanner) {
        userNum = scanner.nextInt();
        recordLike = new int[userNum + 1];
        for (int i = 1; i <= userNum; i++) {
            recordLike[i] = scanner.nextInt();
        }
    }

    int resolve(int l, int right, int k) {
        int sum = 0;
        for (int i = l; i <= right; i++) {
            if (recordLike[i] == k) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] argv) {
//        Scanner scanner= InputUtil.getFileScanner();
        Scanner scanner = new Scanner(System.in);
        toutiao2 main = new toutiao2();
        main.inputArray(scanner);
        int queryTime = scanner.nextInt();
        while ((queryTime--) != 0) {
            int l, r, k;
            l = scanner.nextInt();
            r = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(main.resolve(l, r, k));
        }
    }
}
