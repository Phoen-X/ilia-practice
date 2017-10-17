package com.iredko.testBook.treads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleppingTask extends LiftOff {
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                //Старый стиль
                //Thread/sleep(101);
                //Java SE5/6
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService execService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++) {
            execService.execute(new SleppingTask());
        }
        execService.shutdown();
    }
}
