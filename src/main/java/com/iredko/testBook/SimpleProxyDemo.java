package com.iredko.testBook;

/**
 * Created by IRedko on 13.09.2017.
 */
public class SimpleProxyDemo{
    public static void consumer(MyInterface iface){
        iface.doSomething();
        iface.somethingElse(" bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
