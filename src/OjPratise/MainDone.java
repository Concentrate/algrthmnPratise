package OjPratise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/8/22.
 */
public class MainDone {
    public static void main(String[] argv) {
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node one = new Node();
            one.x = scanner.nextInt();
            one.y = scanner.nextInt();
            array.add(one);
        }
        array.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        for (int i = 0; i < array.size(); i++) {
            boolean isCater=true;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(i).x < array.get(j).x && array.get(i).y < array.get(j).y) {
                    isCater=false;
                    break;
                }
            }
            if(isCater){
                System.out.println(array.get(i).x + " " + array.get(i).y);
            }
        }


    }
}

//class Node {
//    int x;
//    int y;
//
//    public Node() {
//    }
//
//    public Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
