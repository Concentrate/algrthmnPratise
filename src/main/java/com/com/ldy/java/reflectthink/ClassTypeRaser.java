package com.com.ldy.java.reflectthink;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;

public class ClassTypeRaser {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");
        list.getClass().getMethod("add", Object.class).invoke(list, "science is changing the world");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        main2(args);
        boolean isOk= list instanceof ArrayList;
        System.out.println(isOk);
    }


    public static void main2(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("121");
        list.add(new Date());

        list.forEach(System.out::println);
    }
}
