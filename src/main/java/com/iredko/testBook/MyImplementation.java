package com.iredko.testBook;

/**
 * Created by IRedko on 13.09.2017.
 */
public class MyImplementation implements SomeMethods {
    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting "+arg);
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }
}
