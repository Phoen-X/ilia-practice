package com.iredko.testBook;

/**
 * Created by IRedko on 10.08.2017.
 */
public class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbn){
        callbackReference=cbn;
    }
    void go() {
        callbackReference.increment();
    }
}
