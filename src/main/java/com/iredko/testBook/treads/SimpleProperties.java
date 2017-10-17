package com.iredko.testBook.treads;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleProperties implements Runnable {
    private int countDown = 5;
    private volatile double doubleValue;//Без оптимизации
    private  int priority;

    public SimpleProperties(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            //Высокозатратная вызываемая опция
            for (int i=0;i<10000;i++) {
                doubleValue += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService execService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++) {
           execService.execute(new SimpleProperties(Thread.MIN_PRIORITY));
        }
        execService.execute(new SimpleProperties(Thread.MAX_PRIORITY));
        execService.shutdown();
    }
}
