package DataStuctPratise;

import java.util.*;

/**
 * Created by liudeyu on 2017/4/26.
 */
public class Main {
    int MAX_SIZE=16;
    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        if(expr==null||expr.length()==0){
            return 0;
        }
        String[]array1=expr.split(" ");
        List<String >array=new ArrayList<>();
        for(int i=0;i<array1.length;i++){
            if(array1[i].indexOf(" ")==-1&&array1[i].length()!=0){
                array.add(array1[i]);
            }
        }
        Set<String>caclu=new HashSet<>();
        caclu.add("+");
        caclu.add("*");
        caclu.add("^");


        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<array.size();i++){
            String element=array.get(i);
            if(!caclu.contains(element)){
                if(list.size()>16){
                    return -2;
                }
                list.push(Integer.valueOf(element));
            }else{
                if(element.equals("^")){
                    if(list.size()==0){
                        return -1;
                    }
                    int top=list.poll();
                    top++;
                    list.push(top);
                }else{
                    if(list.size()<2){
                        return -1;
                    }
                    int t1=list.poll();
                    int t2=list.poll();
                    if(element.equals("+")){
                        int t3=t1+t2;
                        list.push(t3);
                    }else if(element.equals("*")){
                        int t3=t1*t2;
                        list.push(t3);
                    }
                }
            }
        }
        return list.poll();

    }
}
