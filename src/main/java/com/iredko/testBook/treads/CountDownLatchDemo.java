package com.iredko.testBook.treads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //Все подзадачи совместно используют один объект CountDownLatch
        CountDownLatch latch = new CountDownLatch(SIZE);
        for(int i=0;i<10;i++) {
            exec.execute(new WaitingTask(latch));
        }
        for(int i=0;i<SIZE;i++) {
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("Запущены все задачи");
        exec.shutdown();
    }
}
