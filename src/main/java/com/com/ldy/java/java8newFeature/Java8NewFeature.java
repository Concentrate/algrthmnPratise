package com.com.ldy.java.java8newFeature;

import javafx.concurrent.Task;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * Created by liudeyu on 2017/3/5.
 */
public class Java8NewFeature {
    public static void main(String []argv){
//        forEachPrintSomething();
//        optionUsageShow();
        tasksUsage();
    }


    public static void forEachPrintSomething(){
        List<AppleOne>appleOnes=new ArrayList<>();
        Arrays.asList("1","2","3").forEach(tmp->appleOnes.add(new AppleOne(tmp)));
        appleOnes.forEach(AppleOne::saySomething);
    }

    public static class AppleOne{
        String tmp;

        public AppleOne(String tmp) {
            this.tmp = tmp;
        }

        public static void saySomething(AppleOne one){
            System.out.print(one);
        }

        @Override
        public String toString() {
            return tmp+"-";
        }
    }

    public static void optionUsageShow(){
        Optional<String> stringOption=Optional.ofNullable(null);
        System.out.println(stringOption.orElse("is null"));
    }

    public static void tasksUsage(){
        List<Task>taskList=Arrays.asList(new Task<Integer>(){

            @Override
            protected Integer call() throws Exception {
                Thread.sleep(1000);
                System.out.println("ok");
                return 1;
            }
        },new Task<Integer>(){

            @Override
            protected Integer call() throws Exception {
                Thread.sleep(300);
                System.out.println("ok2");
                return 2;
            }
        });
        
        
        List<String>tmpStrings=Arrays.asList("one","two");
        tmpStrings.stream().map(tmp->{
            return "this is "+tmp+"\n";
        }).forEach(a1->System.out.print(a1));
    }
}
