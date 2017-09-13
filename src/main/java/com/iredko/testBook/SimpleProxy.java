package com.iredko.testBook;

/**
 * Created by IRedko on 13.09.2017.
 */
public class SimpleProxy implements MyInterface{

    private MyInterface proxied;

    public SimpleProxy(MyInterface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse"+arg);
        proxied.somethingElse(arg);
    }
}
