package com.com.ldy.java.reflectthink;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static interface SaySomething {
        void say();
    }

    public static class People implements SaySomething {


        @Override
        public void say() {
            System.out.println("hello,I am people");
        }
    }


    public static class PeopleJdkProxy implements InvocationHandler {

        private SaySomething rawOne;

        public PeopleJdkProxy(SaySomething rawOne) {
            this.rawOne = rawOne;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before jdk proxy exec " + method.getName());
            Object result = method.invoke(rawOne, args);
            System.out.println("After jdk proxy exec " + method.getName());
            return result;
        }
    }


    public static class PeopleCglibProxyCallback implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println(  method + " " + objects + " " + methodProxy);
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after cglib exec");
            return result;
        }
    }

    public static void JdkProxyUsage() {

        SaySomething saySomething = (SaySomething) Proxy.newProxyInstance(SaySomething.class.getClassLoader(), new Class[]{SaySomething.class}, new PeopleJdkProxy(new People()));

        saySomething.say();
    }


    public static void cglibProxyUsage() {
        Enhancer enhancer=new Enhancer();
        enhancer.setCallback(new PeopleCglibProxyCallback());
        enhancer.setInterfaces(new Class[]{SaySomething.class});
        enhancer.setSuperclass(People.class);
        SaySomething saySomething= (SaySomething) enhancer.create();
        saySomething.say();
    }


    public static void main(String[] args) {
        JdkProxyUsage();
        cglibProxyUsage();
    }
}
