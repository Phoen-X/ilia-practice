package com.iredko.testBook.treads;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int striders = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public synchronized int getStriders() {
        return striders;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                synchronized (this) {
                    striders += rand.nextInt(3);//Produces 0,1 or 2
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            //Приемлимый вариант
        } catch (BrokenBarrierException e) {
            //Исключение которое нас интересует
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse "+id+" ";
    }

    public String tracks(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<getStriders();i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(id);
        return stringBuilder.toString();
    }
}
