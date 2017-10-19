package com.iredko.testBook.treads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomacityTest implements Runnable {
    private int i = 0;
    public int getValue(){
        return i;
    }
    private synchronized void evenInctement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenInctement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomacityTest atomacityTest = new AtomacityTest();
        exec.execute(atomacityTest);
        while (true) {
            int val = atomacityTest.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
