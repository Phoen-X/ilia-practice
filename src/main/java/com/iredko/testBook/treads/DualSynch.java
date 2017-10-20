package com.iredko.testBook.treads;

public class DualSynch {
    private Object synchObject = new Object();
    public synchronized void f(){
        for(int i=0; i<5;i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g(){
        synchronized (synchObject) {
            for(int i=0;i<5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
