package JavaLanguageSpecific;

/**
 * Created by liudeyu on 2017/9/9.
 */


class Parent{
    static String name = "hello";
    {
        System.out.println("parent block");
    }
    static {
        System.out.println("parent static block and say: "+name);
    }
    public Parent(){
        System.out.println("parent constructor");
    }
}

class Child extends Parent{
    static String childName = "hello";
    {
        System.out.println("child block");
    }
    static {
        System.out.println("child static block");
    }
    public Child(){
        System.out.println("child constructor");
    }
    public static void childSaySomething(){
        System.out.println("child say something : "+name);
    }
}
class Father{
    public static int m = 33;
    static{
        System.out.println("父类被初始化");
    }
}

class Child1 extends Father{
    static{
        System.out.println("子类被初始化");
    }
}
class ConstTest{
    public static final String NAME = "我是常量";
    static{
        System.out.println("初始化Const类");
    }
}



public class InialOrder {
    
    public static void main(String[] args) {
        System.out.println(Child1.m);
        System.out.println(ConstTest.NAME);
        ConstTest []array=new ConstTest[3];
    }
}