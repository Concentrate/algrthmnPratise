package AlgrithmnPratise;


import java.util.*;

/**
 * Created by liudeyu on 2017/4/7.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Person[]allPeople=new Person[n];
        for(int i=0;i<n;i++){
            Person person=new Person();
            person.score=scanner.nextInt();
            person.deepPower=scanner.nextInt();
            allPeople[i]=person;
        }
        int theMax=0;
        for(int i=0;i<allPeople.length;i++){
            for(int j=0;j<allPeople.length;j++){
                if(i==j){
                    continue;
                }
                if(allPeople[i].score<=allPeople[j].score){
                   continue;
                }else{
                    int t=allPeople[i].score+allPeople[j].deepPower-allPeople[j].score;
                    if(t>allPeople[i].score){
                        allPeople[i].score=t;
                    }
                }
            }
            if(allPeople[i].score+allPeople[i].deepPower>theMax){
                theMax=allPeople[i].score+allPeople[i].deepPower;
            }
        }
        System.out.println(theMax);
    }


}
class Person{
    int score;
    int deepPower;
}
