package com.iredko.testBook.treads;

import java.util.concurrent.TimeUnit;

public class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {
        Thread thread;

        Inner(String name) {
            thread = new Thread(this, name);
            thread.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
                }catch(InterruptedException e){
                System.out.println("sleep().interrupted");
            }
        }

        @Override
        public String toString() {
            return thread.getName()+ ": "+ countDown;
        }
    }

    public InnerRunnable1(String name) {
        this.inner = new Inner(name);
    }
}
