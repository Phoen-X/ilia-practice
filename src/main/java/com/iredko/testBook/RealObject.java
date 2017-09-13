package com.iredko.testBook;

/**
 * Created by IRedko on 13.09.2017.
 */
public class RealObject implements MyInterface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse"+arg);
    }
}
