package com.iredko.testBook;


import java.lang.reflect.Proxy;

/**
 * Created by IRedko on 13.09.2017.
 */
public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(), new Class[]{SomeMethods.class},new MethodSelector(new MyImplementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}
