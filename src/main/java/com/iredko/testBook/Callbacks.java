package com.iredko.testBook;

/**
 * Created by IRedko on 10.08.2017.
 */
public class Callbacks {
    public static void main(String[] args) {
        Calle1 c1 = new Calle1();
        Calle2 c2 = new Calle2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
