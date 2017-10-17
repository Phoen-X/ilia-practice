package com.iredko.testBook.treads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try{
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+ this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DeamonThreadFactory());
        for(int i = 0;i<10;i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("Все демоны запущены");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
