package com.iredko.testBook.treads;

public class SyncObject{
    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();
        new Thread(){
            public void run(){
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
}
