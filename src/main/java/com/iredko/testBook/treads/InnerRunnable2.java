package com.iredko.testBook.treads;

import java.util.concurrent.TimeUnit;

public class InnerRunnable2 {
    private int countDown = 5;
    private Thread thread;

    public InnerRunnable2(String name) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep().interrupted");
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        },name);
        thread.start();
    }
}
