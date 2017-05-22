package JavaLanguageSpecific;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liudeyu on 2017/5/8.
 */
public class ClassPratise {

    private String name;
    int score;
    List<Integer> someArray;

    public ClassPratise() {
        name = "xiaohong";
        score = 10;
        someArray = new ArrayList<>();
        someArray.add(1);
    }

    public static void main(String[] args) {
        List<String> aArray = new ArrayList<>();
        aArray.add("xiaoming");
        aArray.add("xiaogang");
//        Class<? > aClass = aArray.getClass();
//        Class<?>oneStepParentClass=aClass.getClass();
//        Class<?>twoStepParentClass=oneStepParentClass.getClass();
//        printClassInformation(aClass,aArray);
//        printClassInformation(oneStepParentClass,aClass);
//        printClassInformation(twoStepParentClass,oneStepParentClass);

        Class<?> cls = Integer.class;
        try {
            Method method = cls.getMethod("parseInt", new Class[]{String.class});
            System.out.println(method.invoke(null, "123"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void  printClassInformation(Class<? > aClass,Object object){
        Class<?>parentClass=aClass;
        for (Field field : parentClass.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                System.out.println("field name is " + field.getName() + " and field value is " + field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for(Method method:parentClass.getDeclaredMethods()){
            method.setAccessible(true);
            System.out.print("method name is "+method.getName());
            Parameter[]parameters=method.getParameters();
            for(int i=0;i<parameters.length;i++) {
                System.out.print(" the paramter "+i+" is " +parameters[i].getName());
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }
}
