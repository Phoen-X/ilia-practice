package com.iredko.testBook.treads;

import java.util.concurrent.TimeUnit;

public class SimpleDeamons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDeamons());
            daemon.setDaemon(true);//Необходимо вызвать перед старт
            daemon.start();
        }
        System.out.println("Все демоны запущены");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
