package com.iredko.testBook;

import java.lang.reflect.Proxy;

/**
 * Created by IRedko on 13.09.2017.
 */
public class SimpleDynamicProxy {
    public static void consumer(MyInterface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
