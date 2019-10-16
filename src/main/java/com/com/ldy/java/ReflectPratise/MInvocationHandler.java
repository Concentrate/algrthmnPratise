package com.com.ldy.java.ReflectPratise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liudeyu on 2017/9/19.
 */
public class MInvocationHandler implements InvocationHandler {
    private Object object;

    public MInvocationHandler(Object object) {
        this.object = object;
    }

    public static void main(String[] argv) {
        MInvocationHandler handler = new MInvocationHandler(new ProxySell(new  Vender()));
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        SellInterface sellInterface = (SellInterface) Proxy.newProxyInstance(SellInterface.class.getClassLoader(),
                new Class[]{SellInterface.class}, handler);
        sellInterface.sell();

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = null;
        result = method.invoke(object,args);
        System.out.println("after that");
        return result;
    }
}




class Vender implements SellInterface {

    @Override
    public void sell() {
        System.out.println("vender sell ");
    }
}

class ProxySell implements SellInterface {

    private Vender vender;

    public ProxySell(Vender vender) {
        this.vender = vender;
    }

    @Override
    public void sell() {
        System.out.println("In proxySell :");
        vender.sell();
    }
}