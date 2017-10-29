package com.iredko.testBook.treads;

import java.util.concurrent.CountDownLatch;

public class WaitingTask implements Runnable {
    private static int counter= 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Барьер пройден для "+this);
        } catch (InterruptedException e) {
            System.out.println(this+" interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d ",id);
    }
}